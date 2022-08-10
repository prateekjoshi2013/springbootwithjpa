package com.prateek.springbootwithjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * This is not an entity but just a set of attributes
 * we want to have in the student entity this is the purpose
 * of embeddable
 */
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// for overriding the fields with real table column names
@AttributeOverrides({
        @AttributeOverride(name="name",column=@Column(name="guardian_name")),
        @AttributeOverride(name="email",column=@Column(name="guardian_email")),
        @AttributeOverride(name="mobile",column=@Column(name="guardian_mobile")),
})
public class Guardian {
    private String name;
    private String email;
    private String mobile;
}
