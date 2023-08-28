package com.practice.book.springboot.domain.board;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "board")
public class BoardImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inum;

    private String uuid;

    private String imgName;

    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;


}
