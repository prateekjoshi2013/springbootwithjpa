package com.prateek.springbootwithjpa.repository;

import com.prateek.springbootwithjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository  extends JpaRepository<Student,Long> {
    // this is implemented by Jpa only if nameing convention is followed
    // findBy[AttributeName]
    public List<Student> findByFirstName(String name);
    public List<Student> findByFirstNameContainingIgnoreCase(String name);
    public List<Student> findByLastNameNotNull();
    //embeddable property
    public List<Student> findByGuardianName(String name);
    public List<Student> findByFirstNameAndLastName(String firstName,String lastName);

    //defined  based on class name and attributes name and not on table names
    @Query("select s from Student s where s.email=?1")
    public Student getStudentByEmailAddress(String emailId);

    //defined  based on class name and attributes name and not on table names
    @Query("select s.firstName from Student s where s.email=?1")
    public String getStudentNameByEmailAddress(String emailId);

}
