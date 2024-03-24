package com.practice.jeongin.portfolio.web.controller;

import com.practice.jeongin.portfolio.service.User.UserService;
import com.practice.jeongin.portfolio.web.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Log4j2
@Controller
@RequestMapping("/user/")
public class UserController {

    private final UserService userService;
    @PostMapping("/update")
    public String profileUpdate(@RequestBody UserDTO userDTO) {

        log.info("Update Content :" + userDTO);
        userService.modify(userDTO);

        return "index";

    }
}
