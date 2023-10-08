package com.practice.jeongin.portfolio.domain.posts;


import com.practice.jeongin.portfolio.domain.board.Board;
import com.practice.jeongin.portfolio.domain.board.BoardRepository;
import com.practice.jeongin.portfolio.domain.user.Users;
import com.practice.jeongin.portfolio.service.board.BoardService;
import com.practice.jeongin.portfolio.web.dto.BoardDTO;
import com.practice.jeongin.portfolio.web.dto.PageRequestDTO;
import com.practice.jeongin.portfolio.web.dto.PageResultDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.stream.IntStream;

@SpringBootTest
public class BoardRepositoryTests {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;


    @Test
    public void insertBoard() {
        IntStream.rangeClosed(1,100).forEach( i -> {

            Users user = Users.builder().email("TestEmail" + i +"@gmail.com").build();

            Board board = Board.builder()
                    .title("Title"+i)
                    .content("Content"+i)
                    .user(user)
                    .build();

            boardRepository.save(board);
        });
    }

    @Test
    public void testList() {

        PageRequestDTO pageRequestDTO = new PageRequestDTO();

        PageResultDTO<BoardDTO, Object[]> result = boardService.getList(pageRequestDTO);

        for(BoardDTO boardDTO : result.getDtoList()){
            System.out.println(boardDTO);
        }
    }

    @Test
    public void testRead(){
        Object result = boardRepository.getBoardByBno(100L);

        Object[] array = (Object[]) result;

        System.out.println(Arrays.toString(array));
    }
    @Test
    public void testGet() {

        Long bno = 100L;

        BoardDTO boardDTO = boardService.get(bno);

        System.out.println(boardDTO);
    }

    @Test
    public void testRemove() {


        Long bno = 2L;

        boardService.removeWithReplies(bno);
    }

    @Test
    public void testModify() {
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(3L)
                .title("Modified Title")
                .content("Modified Content")
                .build();

        boardService.modify(boardDTO);
    }
//    @Test
//    public void testListPage(){
//        PageRequest pageRequest = PageRequest.of(0,100, Sort.by(Sort.Direction.DESC,"bno"));
//
//        Page<Object[]> result = boardRepository.getListPage(pageRequest);
//
//        for (Object[] objects : result.getContent()){
//            System.out.println(Arrays.toString(objects));
//        }
//    }
//
//
//    @Test
//    public void getBoardWithAll() {
//        List<Object[]> result = boardRepository.getBoardWithAll(100L);
//
//        System.out.println(result);
//
//        for (Object[] arr : result ){
//            System.out.println(Arrays.toString(arr));
//        }
//    }

}
