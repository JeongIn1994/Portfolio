package com.practice.jeongin.portfolio.service.utils;

import com.practice.jeongin.portfolio.domain.util.UtilsRepository;
import com.practice.jeongin.portfolio.web.dto.UtilsDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class UtilsServiceImpl implements UtilsService{

    private final UtilsRepository utilsRepository;

    @Override
    public UtilsDTO findUtilsByCategory(String category){

        return utilsRepository.findUtilsByCategory(category);
    }
}
