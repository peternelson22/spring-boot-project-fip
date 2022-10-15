package com.nelson.flexisaf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Login {

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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private EmployeeUser user;
}
