package com.practice.book.springboot.domain.user;

import com.practice.book.springboot.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@ToString
public class Users extends BaseTimeEntity {

    @Id
    private String email;

    @Column(nullable = false)
    private String name;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

//    @Builder
//    public Users(String name, String email, String picture,Role role) {
//
//        this.name = name;
//        this.email = email;
//        this.picture = picture;
//        this.role = role;
//    }

    public Users update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
