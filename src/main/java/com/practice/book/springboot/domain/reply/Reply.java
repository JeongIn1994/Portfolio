package com.practice.book.springboot.domain.reply;

import com.practice.book.springboot.domain.BaseTimeEntity;
import com.practice.book.springboot.domain.board.Board;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@ToString(exclude = "board")
public class Reply extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    private String text;

    private String replyer;

    @ManyToOne
    private Board board;
}
