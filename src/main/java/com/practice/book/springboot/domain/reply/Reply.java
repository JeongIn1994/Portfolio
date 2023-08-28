package com.practice.book.springboot.domain.reply;

import com.practice.book.springboot.domain.BaseTimeEntity;
import com.practice.book.springboot.domain.board.Board;
import com.practice.book.springboot.domain.user.Users;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@ToString(exclude = {"board","user"})
public class Reply extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    private String text;

    private String replyer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    private Users user;
}
