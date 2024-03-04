package com.practice.jeongin.portfolio.web.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InfoDTO {

    private Long id;

    private String name;

    private LocalDate birthday;

    private String address;

    private String phone_number;

    private String email;

    private String sex;

    private String college;
}
