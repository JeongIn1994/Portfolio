package com.practice.jeongin.portfolio.domain.reply;

import com.practice.jeongin.portfolio.domain.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    @Modifying
    @Query("DELETE FROM Reply r WHERE r.board.bno = :bno")
    void deleteRepliesByBoardBno(@Param("bno") Long bno);

    List<Reply> getRepliesByBoardOrderByRno(Board board);

    List<Reply> findByBoard(Board board);
}
