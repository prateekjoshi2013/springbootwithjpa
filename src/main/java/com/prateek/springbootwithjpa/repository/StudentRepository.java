package com.prateek.springbootwithjpa.repository;

import com.prateek.springbootwithjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
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

}
