package com.prateek.springbootwithjpa.repository;

import com.prateek.springbootwithjpa.entity.Course;
import com.prateek.springbootwithjpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    TeacherRepository teacherRepository;

    @Test
    void saveTeacher() {
        Course course1=Course.builder()
                .title("DBA")
                .credit(5)
                .build();
        Course course2=Course.builder()
                .title("JAVA")
                .credit(6)
                .build();
        Teacher teacher=Teacher.builder()
                .firstName("Qutub")
                .lastName("Khan")
                .courses(new ArrayList<>(Arrays.asList(course1,course2)))
                .build();
        teacherRepository.save(teacher);
    }
}