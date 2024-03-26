package com.practice.jeongin.portfolio.domain.util;

import com.practice.jeongin.portfolio.web.dto.UtilsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UtilsRepository extends JpaRepository<Utils, Long> {

    @Query("Select u From Utils u Where u.category = :category")
    UtilsDTO findUtilsByCategory(@Param("category") String category);
}
