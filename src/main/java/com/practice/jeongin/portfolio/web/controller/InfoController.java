package com.practice.jeongin.portfolio.web.controller;

import com.practice.jeongin.portfolio.config.auth.LoginUser;
import com.practice.jeongin.portfolio.config.auth.dto.SessionUsers;
import com.practice.jeongin.portfolio.domain.user.Role;
import com.practice.jeongin.portfolio.domain.user.UsersRepository;
import com.practice.jeongin.portfolio.service.info.InfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Log4j2
@Controller
public class InfoController {

    private final UsersRepository usersRepository;

    private final InfoService infoService;

    @GetMapping("/setting")
    public String setting(Model model, @LoginUser SessionUsers user){

//        model.addAttribute("info", infoService.get(user.getEmail()));
        model.addAttribute("email", user.getEmail());


        return "setting";
    }

    public Role usersRole(String email) {
        if(email.isEmpty()){
            return null;
        }else{
            return usersRepository.findByEmail(email).get().getRole();
        }
    }
}
