package com.practice.jeongin.portfolio.web.controller;


import com.practice.jeongin.portfolio.domain.info.InfoRepository;
import com.practice.jeongin.portfolio.service.posts.PostsService;
import com.practice.jeongin.portfolio.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {


    private final PostsService postsService;

    private final InfoRepository infoRepository;


    @RequestMapping(value = "/")
    public String index(Model model) {

        model.addAttribute("posts", postsService.finAllDesc());

        return "index";
    }
    @GetMapping("/history/list")
    public String postsList(Model model) {

        model.addAttribute("posts", postsService.finAllDesc());


        return "history/List_history";
    }
    @GetMapping("/history/regist")
    public String postsSave() {
        return "history/Resist_History";
    }

    @GetMapping("/history/view/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "history/View_History";
    }
    @GetMapping("/history/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "history/Update_History";
    }


}
