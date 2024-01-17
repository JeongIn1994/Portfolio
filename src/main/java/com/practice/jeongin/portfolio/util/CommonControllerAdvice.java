package com.practice.jeongin.portfolio.util;

import com.practice.jeongin.portfolio.config.auth.LoginUser;
import com.practice.jeongin.portfolio.config.auth.dto.SessionUsers;
import com.practice.jeongin.portfolio.domain.user.Role;
import com.practice.jeongin.portfolio.domain.user.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
@RequiredArgsConstructor
@Controller
public class CommonControllerAdvice {

    private final UsersRepository usersRepository;
    @ModelAttribute
    public void commonAttributes(Model model, @LoginUser SessionUsers user) {
        if (user != null) {
            model.addAttribute("usersName", user.getName());
            model.addAttribute("picture", user.getPicture());
            model.addAttribute("userEmail", user.getEmail());
            model.addAttribute("role", usersRole(user.getEmail()));
        }
    }

    public Role usersRole(String email) {
        //get Logined User Role
        if(usersRepository.findByEmail(email).isPresent()){
            return usersRepository.findByEmail(email).get().getRole();
        }
        //When User Role Not Found, Set Role "USER"
        else{
            return Role.USER;
        }
    }
}
