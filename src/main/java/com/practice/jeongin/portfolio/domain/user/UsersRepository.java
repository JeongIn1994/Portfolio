package com.practice.jeongin.portfolio.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String mail);

    @Query("Select u From Users u Where u.email = :email")
    Users findByEmailNotNull(@Param("email") String email);

    @Query("Select u From Users u ORDER BY u.createDate")
    List<Users> findAllUsers();

}
