package com.practice.jeongin.portfolio.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class PostsupdateRequestDto {
    private String title;
    private String content;
    private String summary;
    private String language;
    private Date start_date;
    private Date end_date;
    private long progress;


    @Builder
    public PostsupdateRequestDto(String title, String content, String language, String summary, Date start_date, Date end_date, long progress){
        this.title = title;
        this.content = content;
        this.language = language;
        this.summary = summary;
        this.start_date = start_date;
        this.end_date = end_date;
        this.progress = progress;
    }
}
