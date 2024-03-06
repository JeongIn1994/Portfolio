package com.practice.jeongin.portfolio.util;

import com.practice.jeongin.portfolio.config.auth.LoginUser;
import com.practice.jeongin.portfolio.config.auth.dto.SessionUsers;
import com.practice.jeongin.portfolio.domain.info.InfoRepository;
import com.practice.jeongin.portfolio.domain.posts.PostsRepository;
import com.practice.jeongin.portfolio.domain.user.Role;
import com.practice.jeongin.portfolio.domain.user.UsersRepository;
import com.practice.jeongin.portfolio.service.board.BoardService;
import com.practice.jeongin.portfolio.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
@RequiredArgsConstructor
@Controller
@Log4j2
public class CommonControllerAdvice {

    private final UsersRepository usersRepository;
    private final InfoRepository infoRepository;
    private final BoardService boardService;
    private final PostsService postsService;


    @ModelAttribute
    public void commonAttributes(Model model, @LoginUser SessionUsers user) {
        if (user != null) {
            model.addAttribute("usersName", user.getName());
            model.addAttribute("picture", user.getPicture());
            model.addAttribute("userEmail", user.getEmail());
            model.addAttribute("role", usersRole(user.getEmail()));
            model.addAttribute("userInfo", infoRepository.getInfoByEmail(user.getEmail()));
            log.info("Login usersName : "+model.getAttribute("usersName"));
            log.info("Login users role : "+model.getAttribute("role"));
        }

        model.addAttribute("currentBoard", boardService.getTop3Board());
        model.addAttribute("top3Lang", postsService.getCurrent3Language());

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
