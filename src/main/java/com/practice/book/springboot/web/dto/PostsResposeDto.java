package com.practice.book.springboot.web.dto;

import com.practice.book.springboot.domain.posts.Posts;
import com.practice.book.springboot.domain.user.Users;
import lombok.Getter;

@Getter
public class PostsResposeDto {

    private Long id;
    private String title;
    private String content;
    private String user_name;

    public PostsResposeDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.user_name = entity.getUser_name();
    }
}
