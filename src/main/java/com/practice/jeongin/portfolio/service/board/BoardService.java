package com.practice.jeongin.portfolio.service.board;

import com.practice.jeongin.portfolio.domain.board.Board;
import com.practice.jeongin.portfolio.web.dto.BoardDTO;
import com.practice.jeongin.portfolio.domain.user.Users;
import com.practice.jeongin.portfolio.web.dto.PageRequestDTO;
import com.practice.jeongin.portfolio.web.dto.PageResultDTO;

public interface BoardService {

    Long register(BoardDTO dto);

    PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);

    BoardDTO get(Long bno);

    void removeWithReplies(Long bno);

    void modify(BoardDTO boardDTO);

    default Board dtoToEntity(BoardDTO dto){

        Users user = Users.builder().email(dto.getUserEmail()).build();

        return Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .user(user)
                .build();
    }

    default BoardDTO entityToDTO(Board board, Users user, Long replyCount){

        return BoardDTO.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .content(board.getContent())
                .regDate(board.getCreateDate())
                .modDate(board.getModifiedDate())
                .userEmail(user.getEmail())
                .userName(user.getName())
                .replyCount(replyCount.intValue())
                .build();
    }


}
