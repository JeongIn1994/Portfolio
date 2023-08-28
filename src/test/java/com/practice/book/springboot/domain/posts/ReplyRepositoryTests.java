package com.practice.book.springboot.domain.posts;

import com.practice.book.springboot.domain.board.Board;
import com.practice.book.springboot.domain.posts.Posts;
import com.practice.book.springboot.domain.reply.Reply;
import com.practice.book.springboot.domain.reply.ReplyRepository;
import com.practice.book.springboot.domain.user.Role;
import com.practice.book.springboot.domain.user.Users;
import com.practice.book.springboot.service.Reply.ReplyService;
import com.practice.book.springboot.web.dto.ReplyDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class ReplyRepositoryTests {

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private ReplyService replyService;

    @Test
    public void insertReply(){

        IntStream.rangeClosed(1,300).forEach(i -> {

            long bno = (long) (Math.random() * 100 ) + 1;

            Board board = Board.builder()
                    .bno(bno)
                    .build();
//

            Reply reply = Reply.builder()
                    .text("Reply" + i)
                    .board(board)
                    .replyer("Guest")
                    .build();

            replyRepository.save(reply);
        });
    }

    @Test
    public void testListByBoard(){
        List<Reply> replyList = replyRepository.
                getRepliesByBoardOrderByRno(
                        Board.builder().bno(97L).build());
        replyList.forEach(System.out::println);
    }

    @Test
    public void testGetList() {
        Long bno = 84L;

        List<ReplyDTO> replyDTOList = replyService.getList(bno);

        replyDTOList.forEach(System.out::println);
    }
    @Test
    public void testGetMoiveReviews() {

        Board board = Board.builder().bno(100L).build();

        List<Reply> result = replyRepository.findByBoard(board);

        result.forEach(boardReply -> {
            System.out.println(boardReply.getRno());
            System.out.println(boardReply.getText());
            System.out.println(boardReply.getUser().getEmail());
            System.out.println("----------------------------");



        });
    }
}
