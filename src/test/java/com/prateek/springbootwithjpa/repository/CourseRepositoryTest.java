package com.prateek.springbootwithjpa.repository;

import com.prateek.springbootwithjpa.entity.Course;
import com.prateek.springbootwithjpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    void printCourse() {
        List<Course> courses=courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    void saveCourseWithTeacher() {
        Teacher teacher= Teacher.builder()
                .firstName("Priyanka")
                .lastName("Singh")
                .build();
        Course course=Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }
}