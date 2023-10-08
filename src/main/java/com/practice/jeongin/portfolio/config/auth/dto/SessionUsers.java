package com.practice.jeongin.portfolio.config.auth.dto;

import com.practice.jeongin.portfolio.domain.user.Users;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUsers implements Serializable {

    private static final long serialVersionUID = 7946600907589952504L;

    private final String name;
    private final String email;
    private final String picture;

    public SessionUsers(Users user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
