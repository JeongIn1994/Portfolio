package com.practice.book.springboot.web.dto;

import com.practice.book.springboot.domain.posts.Posts;
import com.practice.book.springboot.domain.user.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String summary;
    private String language;
    private Date start_date;
    private Date end_date;

    @Builder
    public PostsSaveRequestDto(String title, String content, String language, String summary, Date start_date, Date end_date){

        this.title = title;
        this.content = content;
        this.language = language;
        this.summary = summary;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .language(language)
                .summary(summary)
                .start_date(start_date)
                .end_date(end_date)
                .build();
    }
}
