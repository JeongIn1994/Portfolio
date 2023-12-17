package com.practice.jeongin.portfolio.service.info;

import com.practice.jeongin.portfolio.web.dto.InfoDTO;

public interface InfoService {
    InfoDTO get(String email);

    default InfoDTO entityToDTO(InfoDTO dto){

        return InfoDTO.builder()
                .id(dto.getId())
                .address(dto.getAddress())
                .sex(dto.getSex())
                .name(dto.getName())
                .college(dto.getCollege())
                .birthday(dto.getBirthday())
                .phone_number(dto.getPhone_number())
                .build();
    }
}
