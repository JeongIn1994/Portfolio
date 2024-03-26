package com.practice.jeongin.portfolio.web.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UtilsDTO {

    private long uid;

    private String uName;

    private String category;

    private String filePath;
}
