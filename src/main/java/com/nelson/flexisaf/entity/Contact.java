package com.nelson.flexisaf.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    private String phoneMobile;

    private String phoneHome;

    private String nextOfKinMobile;

    @NotNull
    @Column(nullable = false)
    private String address;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
