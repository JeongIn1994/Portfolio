package com.practice.jeongin.portfolio.web.controller;

import com.practice.jeongin.portfolio.service.posts.PostsService;
import com.practice.jeongin.portfolio.web.dto.PostsResponseDto;
import com.practice.jeongin.portfolio.web.dto.PostsSaveRequestDto;
import com.practice.jeongin.portfolio.web.dto.PostsupdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Log4j2
@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        log.info("Save History:"+ requestDto);

        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id,
                       @RequestBody PostsupdateRequestDto requestDto){


        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/view/post/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);

        return id;
    }
}
