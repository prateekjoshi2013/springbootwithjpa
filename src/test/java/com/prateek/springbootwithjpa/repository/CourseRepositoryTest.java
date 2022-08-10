package com.prateek.springbootwithjpa.repository;

import com.prateek.springbootwithjpa.entity.Course;
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
}