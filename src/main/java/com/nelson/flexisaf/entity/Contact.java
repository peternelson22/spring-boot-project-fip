package com.nelson.flexisaf.entity;

import com.nelson.flexisaf.entity.dto.ContactDto;
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

    @Column(nullable = false)
    private String address;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

//    public Contact(ContactDto contactDto){
//        this.phoneMobile = contactDto.getPhoneMobile();
//        this.phoneHome = contactDto.getPhoneHome();
//        this.address = contactDto.getAddress();
//        this.nextOfKinMobile = contactDto.getNextOfKinMobile();
//    }

}
