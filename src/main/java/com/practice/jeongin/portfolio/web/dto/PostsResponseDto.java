package com.practice.jeongin.portfolio.web.dto;

import com.practice.jeongin.portfolio.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class PostsResponseDto {

    private final Long id;
    private final String title;
    private final String content;
    private final String language;
    private final LocalDateTime start_date;
    private final LocalDateTime end_date;
    private final String summary;
    private final long progress;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.language = entity.getLanguage();
        this.summary = entity.getSummary();
        this.start_date = entity.getStart_date();
        this.end_date = entity.getEnd_date();
        this.progress = entity.getProgress();
    }
}
