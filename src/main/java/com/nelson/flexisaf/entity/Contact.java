package com.nelson.flexisaf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

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
    private String phoneMobile;

    private String phoneHome;

    private String nextOfKinMobile;

    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
