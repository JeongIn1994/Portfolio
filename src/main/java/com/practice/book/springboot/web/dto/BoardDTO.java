package com.practice.book.springboot.web.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

    private Long bno;

    private String title;

    private String content;

    private String userEmail;

    private String userName;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    private int replyCount;

}
