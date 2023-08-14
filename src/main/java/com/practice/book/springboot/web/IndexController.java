package com.practice.book.springboot.web;

import com.practice.book.springboot.service.posts.PostsService;
import com.practice.book.springboot.web.dto.PostsResposeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("posts", postsService.finAllDesc());

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
