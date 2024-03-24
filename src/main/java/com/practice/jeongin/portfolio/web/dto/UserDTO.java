package com.practice.jeongin.portfolio.web.dto;

import com.practice.jeongin.portfolio.domain.user.Role;
import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String email;

    private String name;

    private Role role;

    private boolean usable;
}
