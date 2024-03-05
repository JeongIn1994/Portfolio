package com.practice.jeongin.portfolio.domain.posts;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("Select p From Posts p Order By p.id Desc")
    List<Posts> findAllDesc();

    @Query("SELECT p.language, COUNT(p.language) AS count " +
            "FROM Posts p " +
            //최근 1년간 데이터 조회하는 조건문 추가할것
            "GROUP BY p.language " +
            "ORDER BY COUNT(p.language) DESC")
    List<Object[]> getCurrent3Language(PageRequest pageRequest);

}
