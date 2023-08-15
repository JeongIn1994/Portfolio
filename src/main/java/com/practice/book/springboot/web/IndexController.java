package com.practice.book.springboot.web;

import com.practice.book.springboot.config.auth.LoginUser;
import com.practice.book.springboot.config.auth.dto.SessionUsers;
import com.practice.book.springboot.service.posts.PostsService;
import com.practice.book.springboot.web.dto.PostsResposeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    private final HttpSession httpSession;
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUsers user) {

        model.addAttribute("posts", postsService.finAllDesc());

        if(user != null) {
            model.addAttribute("usersName", user.getName());
        }
        return "index";
    }

    @GetMapping("/post/save")
    public String postsSave() {
        return "Resist_Posts";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResposeDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "Update_Posts";
    }
}
