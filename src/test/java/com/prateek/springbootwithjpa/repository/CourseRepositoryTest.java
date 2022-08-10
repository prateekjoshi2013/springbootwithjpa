package com.prateek.springbootwithjpa.repository;

import com.prateek.springbootwithjpa.entity.Course;
import com.prateek.springbootwithjpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords= PageRequest.of(0,3);
        Pageable secondPageWithThreeRecords= PageRequest.of(1,2);
        List<Course>courses=courseRepository.findAll(secondPageWithThreeRecords)
                .getContent();
        System.out.println(courses);

    }

    @Test
    public void findAllPaginationWithSorting(){
        Pageable firstPageWithThreeRecordsSortBy= PageRequest.of(0,
                3, Sort.by(Sort.Direction.ASC,"title").and(
                        Sort.by(Sort.Direction.DESC,"credit")));
        Pageable secondPageWithThreeRecords= PageRequest.of(1,2);
        Page<Course> courses=courseRepository.findAll(secondPageWithThreeRecords);
        System.out.println(courses);

    }

    @Test
    void findByTitleContaining() {
        Pageable firstPageTenRecords=PageRequest.of(0,10);
        List<Course>courses=courseRepository.findByTitleContaining("D",firstPageTenRecords).getContent();
        System.out.println(courses);

    }
}