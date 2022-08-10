package com.prateek.springbootwithjpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_material_generator")
    @SequenceGenerator(sequenceName = "course_material_generator",name="course_material_generator",allocationSize = 1)
    private Long id;
    private String url;
    //cascading lets us save the transient course even though it is not saved when we try to save course material
    //fetch type determines whether to fetch the course object right away or only when needed
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name="course_id", //this is the name the Course Material table will have
            referencedColumnName = "id" // this is the attribute the course is referring to
    )
    private Course course;
}
