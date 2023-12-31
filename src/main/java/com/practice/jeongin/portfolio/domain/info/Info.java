package com.practice.jeongin.portfolio.domain.info;

import com.practice.jeongin.portfolio.domain.BaseTimeEntity;
import com.practice.jeongin.portfolio.domain.user.Users;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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

    private Date birthday;

    private String address;

    private String phone_number;

    private String email;

    private String sex;

    private String college;

    @OneToOne
    private Users user;

    public Info update (Date birthday, String address, String phone_number, String email, String sex, String college){
        this.birthday = birthday;
        this.address = address;
        this.phone_number = phone_number;
        this.email = email;
        this.sex = sex;
        this.college = college;

        return this;
    }
}
