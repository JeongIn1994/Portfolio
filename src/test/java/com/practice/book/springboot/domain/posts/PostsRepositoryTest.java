package com.practice.book.springboot.domain.posts;

import com.practice.book.springboot.domain.user.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.AfterEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    private PostsRepository postsRepository;

//    @AfterEach
//    public void cleanup(){
//        postsRepository.deleteAll();
//    }

    @Test
    public void get_post(){
        String title = "test post";
        String content = "test content";
        String testUser = "test User";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .build());


        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void register_BaseTimeEntity() {
        LocalDateTime now = LocalDateTime.of(2023,8,3,0,0,0);
        String testUser = "test User";
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>createDate="
                + posts.getCreateDate() + ",modifiedDate="+ posts.getModifiedDate());

//        assertThat(posts.getCreateDate()).isEqualTo(now);
//        assertThat(posts.getModifiedDate()).isEqualTo(now);
    }
    @Test
    public void insertPost(){

        IntStream.rangeClosed(1,100).forEach(i -> {

            Posts post = Posts.builder()
                    .title("title" + i)
                    .content("Content" + i)
                    .build();
            postsRepository.save(post);

        });
    }

    @Test
    public void testRead(){
        Optional<Posts> result = postsRepository.findById(100L);

        Posts post = result.get();

        System.out.println(post);
    }

    @Test
    public void testGetPostByPid(){

        Object result = postsRepository.findById(100L);

        Object[] array = (Object[]) result;

        System.out.println(Arrays.toString(array));
    }

}
