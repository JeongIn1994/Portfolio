package com.practice.jeongin.portfolio.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    ADMIN("ROLE_ADMIN","Admin"),
    USER("ROLE_USER","User");

    private final String Key;
    private final String title;
}
