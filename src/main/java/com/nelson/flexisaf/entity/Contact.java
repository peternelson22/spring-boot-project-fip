package com.nelson.flexisaf.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import static javax.persistence.FetchType.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contacts")
public class Contact {

    @Id
    @SequenceGenerator(
            name = "contact_sequence",
            sequenceName = "contact_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "contact_sequence"
    )
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "Phone number cannot be empty")
    private String phoneMobile;

    private String phoneHome;

    private String nextOfKinMobile;

    @Column(nullable = false)
    @NotBlank(message = "Address cannot be empty")
    private String address;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;



}
