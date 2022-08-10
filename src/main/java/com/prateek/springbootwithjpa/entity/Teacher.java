package com.prateek.springbootwithjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "teacher_id_generator")
    @SequenceGenerator(sequenceName = "teacher_id_generator",allocationSize = 1,name="teacher_id_generator")
    private Long id;
    private String firstName;
    private String lastName;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name="teacher_id",
            referencedColumnName = "id"
    )
    private List<Course> courses;
}
