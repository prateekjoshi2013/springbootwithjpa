package com.prateek.springbootwithjpa.repository;

import com.prateek.springbootwithjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // this is implemented by Jpa only if nameing convention is followed
    // findBy[AttributeName]
    public List<Student> findByFirstName(String name);
    public List<Student> findByFirstNameContainingIgnoreCase(String name);
    public List<Student> findByLastNameNotNull();
    //embeddable property
    public List<Student> findByGuardianName(String name);
    public List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    //defined  based on class name and attributes name and not on table names
    @Query("select s from Student s where s.email=?1")
    public Student getStudentByEmailAddress(String emailId);

    //defined  based on class name and attributes name and not on table names
    @Query("select s.firstName from Student s where s.email=?1")
    public String getStudentNameByEmailAddress(String emailId);

    @Query(value = "select * from tbl_student where email_address=?1", nativeQuery = true)
    public Student getStudentByEmailAddressNativeQuery(String emailId);

    @Query(value = "select first_name from tbl_student where email_address=?1", nativeQuery = true)
    public String getStudentNameByEmailAddressNativeQuery(String emailId);

    @Query(value = "select first_name from tbl_student where email_address= :emailId", nativeQuery = true)
    public String getStudentNameByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    //denotes the query is for update or create
    @Modifying
    //transactional ideally done on service/manager layer
    // so all the updates can bedone sequentially under one method
    @Transactional
    @Query(
            value="update tbl_student set first_name=:firstName where email_address=:emailId ",
            nativeQuery = true
    )
    public int updateStudentNameByEmailAddressNativeNamedParam(@Param("firstName") String firstName,@Param("emailId") String emailId);



}
