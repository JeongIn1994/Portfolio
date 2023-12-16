package com.practice.jeongin.portfolio.web.dto;

import com.practice.jeongin.portfolio.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class PostsListResponseDto {
    private final Long id;
    private final String title;
    private final String summary;
    private final String language;
    private final Date start_date;
    private final Date end_date;
    private final LocalDateTime modifiedDate;
    private final long progress;

    public PostsListResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.summary = entity.getSummary();
        this.language = entity.getLanguage();
        this.start_date = entity.getStart_date();
        this.end_date = entity.getEnd_date();
        this.modifiedDate = entity.getModifiedDate();
        this.progress = entity.getProgress();

    }
}
