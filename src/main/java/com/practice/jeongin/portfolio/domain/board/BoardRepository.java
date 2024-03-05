package com.practice.jeongin.portfolio.domain.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query(value = "Select b, u, count(r)" +
            " From Board b " +
            " Left Join b.user u "+
            " left JOIN  Reply r On r.board = b" +
            " group by b, u",
    countQuery = "Select count(b) From Board b")
    Page<Object[]> getBoardWithReplyCount(Pageable pageable);

    @Query("SELECT b, u, COUNT(r)" +
            " FROM Board b LEFT JOIN b.user u " +
            " LEFT OUTER JOIN Reply r ON r.board = b" +
            " WHERE b.bno = :bno" +
            " GROUP BY b, u, b.bno")
    Object getBoardByBno(@Param("bno") Long bno);

    @Query("Select b From Board b Order by b.createDate Desc")
    List<Board> getCurrent3Board(Pageable pageable);
}
