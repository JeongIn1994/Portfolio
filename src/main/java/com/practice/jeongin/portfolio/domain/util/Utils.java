package com.practice.jeongin.portfolio.domain.util;

import com.practice.jeongin.portfolio.domain.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Utils extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uid;

    @Column
    private String uName;

    @Column
    private String category;

    @Column
    private String filePath;

    public void update(long uid, String uName, String category, String filePath){
        this.uid = uid;
        this.uName = uName;
        this.category = category;
        this.filePath = filePath;
    }
}
