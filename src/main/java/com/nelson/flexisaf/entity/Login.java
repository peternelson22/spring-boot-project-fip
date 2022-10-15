package com.nelson.flexisaf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Login {

    @Id
    @SequenceGenerator(
            name = "login_sequence",
            sequenceName = "login_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "login_sequence"
    )
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    @NotNull
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, insertable = false)
    private EmployeeUser user;
}
