package com.practice.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsupdateRequestDto {
    private String title;
    private String content;

    @Builder
    public PostsupdateRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }
}
