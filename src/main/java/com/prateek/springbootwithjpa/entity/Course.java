package com.prateek.springbootwithjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "course_id_generator")
    @SequenceGenerator(sequenceName = "course_id_generator",name = "course_id_generator",allocationSize = 1)
    private Long id;
    private String title;
    private Integer credit;

    //needed for bidirectional mapping to fetch the course material
    //mappedBy tells us that the relationship is already mapped by
    // course attribute in CourseMaterial
    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name="teacher_id",
            referencedColumnName = "id"
    )
    private Teacher teacher;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "student_course_map",
            joinColumns = @JoinColumn(
                    name="course_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name="student_id",
                    referencedColumnName = "id"
            )
    )
    private List<Student> students;

    public void addStudents(Student student){
        if (students==null) students=new ArrayList<>();
        students.add(student);
    }

}
