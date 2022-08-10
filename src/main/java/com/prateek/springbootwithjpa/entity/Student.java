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
     *
     * Sequence -  along with Sequence generator definition - creates a sequence with the table and
     *  uses it for id gen
     */
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;
    @Column(name="email_address")
    private String email;
    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;

}

