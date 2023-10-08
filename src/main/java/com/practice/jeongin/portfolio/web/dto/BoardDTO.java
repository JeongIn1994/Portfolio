package com.practice.jeongin.portfolio.web.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Builder.Default
    private List<UploadResultDTO> resultDTOList = new ArrayList<>();

}
