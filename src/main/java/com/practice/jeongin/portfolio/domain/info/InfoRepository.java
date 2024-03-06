package com.practice.jeongin.portfolio.domain.info;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InfoRepository extends JpaRepository<Info, Long> {

    @Query("SELECT i FROM Info i where i.user.email = :email")
    Object getInfoByEmail(@Param("email") String email);

    @Query("Select i From Info i Order By i.createDate Desc")
    Object getUserInfo();

}
