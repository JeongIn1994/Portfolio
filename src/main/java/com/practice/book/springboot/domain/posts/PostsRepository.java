package com.practice.book.springboot.domain.posts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("Select p From Posts p Order By p.id Desc")
    List<Posts> findAllDesc();

    @Query("Select p, r from Posts p left JOIN Reply r ON r.post = p where p.id = :id")
    List<Object[]> getPostWithReply(@Param("id") Long id);

//    @Query(value = "select p, u, count(r) " +
//            "from Posts p " +
//            "left join p.user_name u " +
//            "left join Reply r on r.post = p " +
//            "group by p",
//            countQuery = "Select count(p) From Posts p")
//    Page<Object[]> getPostWithReplyCount(Pageable pageable);
}
