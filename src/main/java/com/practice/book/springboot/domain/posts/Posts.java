package com.practice.book.springboot.domain.posts;

import com.practice.book.springboot.domain.BaseTimeEntity;
import com.practice.book.springboot.domain.user.Users;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;


//    @Builder
//    public Posts(String title, String content, Users author){
//        this.title = title;
//        this.content = content;
//        this.author = author;
//    }
//
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
