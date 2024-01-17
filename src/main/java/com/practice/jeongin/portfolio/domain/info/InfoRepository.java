package com.practice.jeongin.portfolio.domain.info;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InfoRepository extends JpaRepository<Info, Long> {

    @Query("Select i.college, i.address, i.birthday, i.email, i.name, i.phone_number, i.sex " +
            "FROM Info i where i.email =:email")
    Object getInfoByEmail(@Param("email") String email);

    @Query("Select i From Info i Order By i.id Desc")
    Object getUserInfo();

}
