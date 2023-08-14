package com.practice.book.springboot.web;

import com.practice.book.springboot.domain.posts.Posts;
import com.practice.book.springboot.domain.posts.PostsRepository;
import com.practice.book.springboot.service.posts.PostsService;
import com.practice.book.springboot.web.dto.PostsResposeDto;
import com.practice.book.springboot.web.dto.PostsSaveRequestDto;
import com.practice.book.springboot.web.dto.PostsupdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id,
                       @RequestBody PostsupdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResposeDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);

        return id;
    }
}
