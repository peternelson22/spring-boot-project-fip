package com.nelson.flexisaf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ContactDto {

    private String phoneMobile;
    private String phoneHome;
    private String address;
    private String nextOfKinMobile;
    private String name;
    private String email;
    private Long employeeId;

}
