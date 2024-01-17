package com.practice.jeongin.portfolio.service.board;

import com.practice.jeongin.portfolio.domain.board.Board;
import com.practice.jeongin.portfolio.domain.board.BoardRepository;
import com.practice.jeongin.portfolio.domain.reply.ReplyRepository;
import com.practice.jeongin.portfolio.domain.user.Users;
import com.practice.jeongin.portfolio.web.dto.BoardDTO;
import com.practice.jeongin.portfolio.web.dto.PageRequestDTO;
import com.practice.jeongin.portfolio.web.dto.PageResultDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    private final ReplyRepository replyRepository;

    @Override
    public Long register(BoardDTO dto){

        log.info(dto);

        Board board = dtoToEntity(dto);

        boardRepository.save(board);

        return board.getBno();
    }

    @Override
    public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO){

        log.info(pageRequestDTO);

        Function<Object[], BoardDTO> fn =
                (en -> entityToDTO((Board) en[0],(Users) en[1], (Long) en[2]));

        Page<Object[]> result = boardRepository.getBoardWithReplyCount(
                pageRequestDTO.getPageable(Sort.by("bno").descending()));

        return new PageResultDTO<>(result, fn);
    }

    public BoardDTO get(Long bno){

        Object result = boardRepository.getBoardByBno(bno);

        Object[] array = (Object[]) result;

        return entityToDTO((Board) array[0], (Users) array[1], (Long) array[2]);
    }

    @Transactional
    @Override
    public void removeWithReplies(Long bno){

        replyRepository.deleteRepliesByBoardBno(bno);

        boardRepository.deleteById(bno);
    }

    @Transactional
    @Override
    public void modify(BoardDTO boardDTO) {

        Board board = boardRepository.getById(boardDTO.getBno());

        board.changeContent(boardDTO.getContent());

        board.changeTitle(boardDTO.getTitle());

        boardRepository.save(board);
    }

    @Override
    public List<Board> getTop3Board() {
        PageRequest pageable = PageRequest.of(0,3);
        return boardRepository.getCurrent3Board(pageable);
    }
}


