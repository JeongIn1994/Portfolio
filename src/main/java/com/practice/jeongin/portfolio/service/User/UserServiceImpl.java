package com.practice.jeongin.portfolio.service.User;

import com.practice.jeongin.portfolio.domain.user.Users;
import com.practice.jeongin.portfolio.domain.user.UsersRepository;
import com.practice.jeongin.portfolio.web.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;

    @Override
    public void modify(UserDTO userDTO){
        Users user =  usersRepository. findByEmailNotNull(userDTO.getEmail());
        user.update(userDTO.getRole(),userDTO.isUsable());
        log.info("Find User :"+ user);
        log.info("IsSave? :" + usersRepository.save(user));
    }

}
