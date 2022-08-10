package com.prateek.springbootwithjpa.repository;

import com.prateek.springbootwithjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository  extends JpaRepository<Student,Long> {

}
