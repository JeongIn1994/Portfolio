package com.practice.jeongin.portfolio.service.Reply;

import com.practice.jeongin.portfolio.domain.board.Board;
import com.practice.jeongin.portfolio.domain.reply.Reply;
import com.practice.jeongin.portfolio.web.dto.ReplyDTO;

import java.util.List;

public interface ReplyService {

    Long register(ReplyDTO replyDTO);

    List<ReplyDTO> getList(Long bno);

    void modify(ReplyDTO replyDTO);

    void remove(Long rno);

    default Reply dtoToEntity(ReplyDTO replyDTO){

        Board board = Board.builder().bno(replyDTO.getBno()).build();

        return Reply.builder()
                .rno(replyDTO.getRno())
                .text(replyDTO.getText())
                .replyer(replyDTO.getReplyer())
                .board(board)
                .build();
    }

    default ReplyDTO entityToDTO(Reply reply){
        return ReplyDTO.builder()
                .rno(reply.getRno())
                .text(reply.getText())
                .replyer(reply.getReplyer())
                .regDate(reply.getCreateDate())
                .modDate(reply.getModifiedDate())
                .build();
    }
}
