package com.prateek.springbootwithjpa.repository;

import com.prateek.springbootwithjpa.entity.Course;
import com.prateek.springbootwithjpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterialTest(){
        Course course= Course.builder()
                .credit(7)
                .title("Computer Network")
                .build();
        CourseMaterial courseMaterial=CourseMaterial.builder()
                .url("www.dbf.com")
                .course(course)
                .build();
        //this works without saving course material first because of cascading all on the relationship
        courseMaterialRepository.save(courseMaterial);

    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials=courseMaterialRepository.findAll();

    }

    @Test
    void fetchAllCourseMaterialsLazily() {
        System.out.println(courseMaterialRepository.findAll());
    }
}