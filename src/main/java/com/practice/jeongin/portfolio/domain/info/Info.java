package com.practice.jeongin.portfolio.domain.info;

import com.practice.jeongin.portfolio.domain.BaseTimeEntity;
import com.practice.jeongin.portfolio.domain.user.Users;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "user")
public class Info extends BaseTimeEntity {

    @Id
    private long id;

    private String name;

    private LocalDate birthday;

    private long age;

    private String address;

    private String phone_number;

    private String email;

    private String sex;

    private String college;

    @OneToOne
    private Users user;

    public Info update (String name,LocalDate birthday,String address, String phone_number, String sex, String college){
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.age = calculateAge(birthday);
        this.phone_number = phone_number;
        this.sex = sex;
        this.college = college;

        return this;
    }

    //calculate User Age
    public static int calculateAge(LocalDate birthday){
        LocalDate currentDate = LocalDate.now();

        return Period.between(birthday, currentDate).getYears();

    }
}
