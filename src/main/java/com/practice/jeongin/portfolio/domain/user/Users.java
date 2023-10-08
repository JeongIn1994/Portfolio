package com.practice.jeongin.portfolio.domain.user;

import com.practice.jeongin.portfolio.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;


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


    public Users update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
