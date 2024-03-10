package com.practice.jeongin.portfolio.web.controller;

import com.practice.jeongin.portfolio.config.auth.LoginUser;
import com.practice.jeongin.portfolio.config.auth.dto.SessionUsers;
import com.practice.jeongin.portfolio.domain.user.Role;
import com.practice.jeongin.portfolio.domain.user.UsersRepository;
import com.practice.jeongin.portfolio.service.info.InfoService;
import com.practice.jeongin.portfolio.web.dto.InfoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Log4j2
@Controller
@RequestMapping("/info/")
public class InfoController {

    private final UsersRepository usersRepository;

    private final InfoService infoService;

   @PostMapping("/update")
   public String update(@RequestBody InfoDTO infoDTO) {

       log.info("Update Content :" + infoDTO);
       infoService.modify(infoDTO);

       return "index";
   }

    public Role usersRole(String email) {
        if(email.isEmpty()){
            return null;
        }else{
            return usersRepository.findByEmail(email).get().getRole();
        }
    }
}
