package com.practice.book.springboot.domain.posts;

import com.practice.book.springboot.domain.user.Role;
import com.practice.book.springboot.domain.user.Users;
import com.practice.book.springboot.domain.user.UsersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class UsersRepositoryTests {

    @Autowired
    private UsersRepository usersRepository;

    @Test
    public void insertUsers(){

        IntStream.rangeClosed(1,100).forEach( i -> {
            Users user = Users.builder()
                    .name("user" + i)
                    .email("TestEmail" + i + "@gmail.com")
                    .picture("TestPicture")
                    .role(Role.USER)
                    .build();
            usersRepository.save(user);
        });
    }
}
