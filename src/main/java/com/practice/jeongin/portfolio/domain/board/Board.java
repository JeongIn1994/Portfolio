package com.practice.jeongin.portfolio.domain.board;

import com.practice.jeongin.portfolio.domain.BaseTimeEntity;
import com.practice.jeongin.portfolio.domain.user.Users;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "user")
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;

    @Column(columnDefinition = "text")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    private Users user;

    public void changeTitle(String title){
        this.title = title;
    }

    public void changeContent(String content) {
        this.content = content;
    }


}
