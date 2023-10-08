package com.practice.jeongin.portfolio.domain.reply;

import com.practice.jeongin.portfolio.domain.BaseTimeEntity;
import com.practice.jeongin.portfolio.domain.board.Board;
import com.practice.jeongin.portfolio.domain.user.Users;
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
