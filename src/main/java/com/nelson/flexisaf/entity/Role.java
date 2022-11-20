package com.nelson.flexisaf.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.CascadeType.*;

@Entity
@Setter @Getter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "roles")
public class Role {

    @Id
    @SequenceGenerator(
            name = "role_sequence",
            sequenceName = "role_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "role_sequence"
    )
    private Long id;

    private String roleName;

    @ManyToMany(mappedBy = "role", cascade = ALL)
    @ToString.Exclude
    private Set<EmployeeUser> employeeUsers;

}
