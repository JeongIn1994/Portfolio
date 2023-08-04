package com.practice.book.springboot.domain.posts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.AfterEach;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void get_post(){
        String title = "test post";
        String content = "test content";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("be7814@gmail.com")
                .build());


        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void register_BaseTimeEntity() {
        LocalDateTime now = LocalDateTime.of(2023,8,3,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>createDate="
                + posts.getCreateDate() + ",modifiedDate="+ posts.getModifiedDate()
                + ",id= "+ posts.getAuthor() );

//        assertThat(posts.getCreateDate()).isEqualTo(now);
//        assertThat(posts.getModifiedDate()).isEqualTo(now);
    }
}
