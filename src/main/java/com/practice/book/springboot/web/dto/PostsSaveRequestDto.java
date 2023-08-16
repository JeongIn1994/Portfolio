package com.practice.book.springboot.web.dto;

import com.practice.book.springboot.domain.posts.Posts;
import com.practice.book.springboot.domain.user.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String user_name;

    @Builder
    public PostsSaveRequestDto(String title, String content, String user_name){

        this.title = title;
        this.content = content;
        this.user_name = user_name;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .user_name(user_name)
                .build();
    }
}
