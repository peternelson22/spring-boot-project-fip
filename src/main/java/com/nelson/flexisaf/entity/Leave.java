package com.nelson.flexisaf.entity;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import java.time.LocalDateTime;

public class Leave {

    @SequenceGenerator(
            name = "leave_sequence",
            sequenceName = "leave_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "leave_sequence"
    )
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime date;

    @Column(columnDefinition = "SMALLINT default 0")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean state;
}
