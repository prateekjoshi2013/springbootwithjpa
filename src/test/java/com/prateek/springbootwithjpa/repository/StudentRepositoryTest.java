package com.prateek.springbootwithjpa.repository;

import com.prateek.springbootwithjpa.entity.Guardian;
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
//                .guardianEmail("testFather.xyz.com")
//                .guardianName("testFather")
//                .guardianMobile("123-123-1234")
                .build();
        studentRepository.save(student);

    }
@Test
    public void saveStudentWithGuardians(){
        Guardian guardian= Guardian.builder()
                .name("test2father")
                .email("test2father@xyz.com")
                .mobile("432-657-8989")
                .build();

        Student student=Student.builder()
                .firstName("test2")
                .lastName("2")
                .email("test22@xyz.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> students=studentRepository.findAll();
        System.out.println(students);
    }

    @Test
    void printStudentByfirstName() {
        System.out.println(studentRepository.findByFirstName("test2"));
    }

    @Test
    void printStudentByFirstNameContaining() {
        System.out.println(studentRepository.findByFirstNameContainingIgnoreCase("test2"));
    }

    @Test
    void printStudentBasedOnGuardianName() {
        System.out.println(studentRepository.findByGuardianName("test2father"));
        System.out.println(studentRepository.findByFirstNameAndLastName("test2","2"));

    }

    @Test
    void getByEmailAddressUsingJpqlQuery() {
        System.out.println(studentRepository.getStudentByEmailAddress("test1@xyz.com"));
        System.out.println(studentRepository.getStudentNameByEmailAddress("test1@xyz.com"));
    }

    @Test
    void getByEmailAddressUsingNativeQuery() {
        System.out.println(studentRepository.getStudentByEmailAddressNativeQuery("test1@xyz.com"));
        System.out.println(studentRepository.getStudentNameByEmailAddressNativeQuery("test1@xyz.com"));
        System.out.println(studentRepository.getStudentNameByEmailAddressNativeNamedParam("test1@xyz.com"));
        System.out.println(studentRepository.updateStudentNameByEmailAddressNativeNamedParam("test11","test1@xyz.com"));

    }


}