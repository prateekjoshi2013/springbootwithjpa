package com.prateek.springbootwithjpa.repository;

import com.prateek.springbootwithjpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student=Student.builder()
                .email("test1@xyz.com")
                .firstName("test")
                .lastName("1")
                .guardianEmail("testFather.xyz.com")
                .guardianName("testFather")
                .guardianMobile("123-123-1234")
                .build();
        studentRepository.save(student);

    }

    @Test
    public void printAllStudent(){
        List<Student> students=studentRepository.findAll();
        System.out.println(students);
    }
}