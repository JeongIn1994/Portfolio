package com.practice.jeongin.portfolio.domain.posts;

import com.practice.jeongin.portfolio.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@ToString
public class Posts extends BaseTimeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(nullable = true)
    private String summary;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String language;

    @Column(columnDefinition = "TEXT", nullable = false)
    private Date start_date;

    @Column(columnDefinition = "TEXT", nullable = false)
    private Date end_date;

    @Column(nullable = false)
    private long progress;

    public void update(String title, String content, String language, String summary, Date start_date, Date end_date, long progress){
        this.title = title;
        this.content = content;
        this.language = language;
        this.summary = summary;
        this.start_date = start_date;
        this.end_date = end_date;
        this.progress = progress;
    }
}
