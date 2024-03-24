package com.practice.jeongin.portfolio.domain.user;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    ADMIN("ROLE_ADMIN","Admin"),
    USER("ROLE_USER","User");

    private final String Key;
    private final String title;

    public static Role fromValue(String value) {
        for (Role role : Role.values()) {
            if (role.getValue().equalsIgnoreCase(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid Role value: " + value);
    }

    @JsonValue
    public String getValue() {
        return title;
    }
}
