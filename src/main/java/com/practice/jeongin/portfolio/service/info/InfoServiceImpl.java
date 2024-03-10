package com.practice.jeongin.portfolio.service.info;

import com.practice.jeongin.portfolio.domain.board.Board;
import com.practice.jeongin.portfolio.domain.info.Info;
import com.practice.jeongin.portfolio.domain.info.InfoRepository;
import com.practice.jeongin.portfolio.web.dto.BoardDTO;
import com.practice.jeongin.portfolio.web.dto.InfoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@RequiredArgsConstructor
public class InfoServiceImpl implements InfoService{

    private final InfoRepository infoRepository;

    public InfoDTO get(String email) {

        Object result = infoRepository.getInfoByEmail(email);

        return entityToDTO((InfoDTO) result);
    }

    @Transactional
    @Override
    public void modify(InfoDTO infoDTO) {

        Info info = (Info) infoRepository.getInfoByEmail(infoDTO.getEmail());

        info.update(infoDTO.getName(),infoDTO.getBirthday(),infoDTO.getAddress(),infoDTO.getPhone_number(),infoDTO.getSex(),infoDTO.getCollege());

        infoRepository.save(info);
    }
}
