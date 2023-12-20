package com.practice.jeongin.portfolio.web.controller;

import com.practice.jeongin.portfolio.config.auth.LoginUser;
import com.practice.jeongin.portfolio.config.auth.dto.SessionUsers;
import com.practice.jeongin.portfolio.domain.user.Role;
import com.practice.jeongin.portfolio.domain.user.UsersRepository;
import com.practice.jeongin.portfolio.service.posts.PostsService;
import com.practice.jeongin.portfolio.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final UsersRepository usersRepository;

    private final PostsService postsService;
    @RequestMapping(value = {"/", "/history/**"})
    public String index(Model model, @LoginUser SessionUsers user) {

        model.addAttribute("posts", postsService.finAllDesc());

        if(user != null) {
            model.addAttribute("usersName", user.getName());
            model.addAttribute("picture", user.getPicture());
            model.addAttribute("role", usersRole(user.getEmail()));
        }

        return "index";
    }
    @GetMapping("/history/list")
    public String postsList(Model model, @LoginUser SessionUsers user) {

        model.addAttribute("posts", postsService.finAllDesc());

        if(user != null) {
            model.addAttribute("usersName", user.getName());
            model.addAttribute("picture", user.getPicture());
            model.addAttribute("role", usersRole(user.getEmail()));
        }

        return "/history/List_Posts";
    }
    @GetMapping("/history/regist")
    public String postsSave(Model model, @LoginUser SessionUsers user) {

        model.addAttribute("usersName", user.getName());

        if(user != null) {
            model.addAttribute("usersName", user.getName());
            model.addAttribute("picture", user.getPicture());
            model.addAttribute("role", usersRole(user.getEmail()));
        }

        return "/history/Resist_Posts";
    }

    @GetMapping("/history/view/{id}")
    public String viewPost(@PathVariable Long id, Model model, @LoginUser SessionUsers user) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        if(user != null) {
            model.addAttribute("usersName", user.getName());
            model.addAttribute("picture", user.getPicture());
            model.addAttribute("role", usersRole(user.getEmail()));
        }

        return "/history/View_Posts";
    }
    @GetMapping("/history/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model, @LoginUser SessionUsers user) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        if(user != null) {
            model.addAttribute("usersName", user.getName());
        }

        return "/history/Update_Posts";
    }

    public Role usersRole(String email) {

        return usersRepository.findByEmail(email).get().getRole();
    }
}
