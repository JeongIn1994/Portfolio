package com.practice.book.springboot.domain.reply;

import com.practice.book.springboot.domain.BaseTimeEntity;
import com.practice.book.springboot.domain.posts.Posts;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@ToString(exclude = "post")
public class Reply extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    private String text;

    private String replyer;

    @ManyToOne
    private Posts post;
}
