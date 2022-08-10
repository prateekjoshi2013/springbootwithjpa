package com.prateek.springbootwithjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Student {
    /**
     * Auto (default) - just a primary key and no auto generation
     */
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String guardianName;
    private String guadianEmail;
    private String guardianMobile;

}

