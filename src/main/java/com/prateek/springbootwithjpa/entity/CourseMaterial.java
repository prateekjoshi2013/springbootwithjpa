package com.prateek.springbootwithjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CourseMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_material_generator")
    @SequenceGenerator(sequenceName = "course_material_generator",name="course_material_generator",allocationSize = 1)
    private Long id;
    private String url;
    @OneToOne
    @JoinColumn(
            name="course_id", //this is the name the Course Material table will have
            referencedColumnName = "id" // this is the attribute the course is referring to
    )
    private Course course;
}
