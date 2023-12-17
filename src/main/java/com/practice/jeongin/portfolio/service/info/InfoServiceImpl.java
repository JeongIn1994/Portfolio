package com.practice.jeongin.portfolio.service.info;

import com.practice.jeongin.portfolio.domain.info.InfoRepository;
import com.practice.jeongin.portfolio.web.dto.InfoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class InfoServiceImpl implements InfoService{

    private final InfoRepository infoRepository;

    public InfoDTO get(String email) {

        Object result = infoRepository.getInfoByEmail(email);

        return entityToDTO((InfoDTO) result);
    }
}
