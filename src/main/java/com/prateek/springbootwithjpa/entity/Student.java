package com.prateek.springbootwithjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name="tbl_student")
public class Student {
    /**
     * Auto (default) - just a primary key and no auto generation
     */
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    @Column(name="email_address")
    private String email;
    private String guardianName;
    private String guadianEmail;
    private String guardianMobile;

}

