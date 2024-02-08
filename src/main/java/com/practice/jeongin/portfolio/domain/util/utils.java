package com.practice.jeongin.portfolio.domain.util;

import com.practice.jeongin.portfolio.domain.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class utils extends BaseTimeEntity {

    @Id
    private long uid;

    private String uName;

    private String category;

    private String filePath;


}