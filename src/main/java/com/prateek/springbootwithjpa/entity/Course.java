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
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "course_id_generator")
    @SequenceGenerator(sequenceName = "course_id_generator",name = "course_id_generator",allocationSize = 1)
    private Long id;
    private String title;
    private Integer credit;
}
