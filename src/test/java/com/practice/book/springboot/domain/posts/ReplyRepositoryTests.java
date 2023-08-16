package com.practice.book.springboot.domain.posts;

import com.practice.book.springboot.domain.posts.Posts;
import com.practice.book.springboot.domain.reply.Reply;
import com.practice.book.springboot.domain.reply.ReplyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class ReplyRepositoryTests {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void insertReply(){
        IntStream.rangeClosed(1,300).forEach(i -> {

            long pno = (long) (Math.random() * 100 ) + 1;

            Posts post = Posts.builder()
                    .id((long) pno)
                    .build();

            Reply reply = Reply.builder()
                    .text("Reply" + i)
                    .post(post)
                    .replyer("Guest")
                    .build();

            replyRepository.save(reply);
        });
    }
}
