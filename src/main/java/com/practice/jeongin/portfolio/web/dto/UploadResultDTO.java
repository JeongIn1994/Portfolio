package com.practice.jeongin.portfolio.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;
@Data
@AllArgsConstructor
@Log4j2
public class UploadResultDTO implements Serializable {

    private String fileName;
    private String uuid;
    private String folderPath;



    @JsonProperty
    public String getImageUrl() {
        return folderPath + "/" + uuid + "_" + fileName;
    }

    @JsonProperty
    public String getThumbnailURL() {
        return folderPath+"/s_"+ uuid + "_" + fileName;
    }
}
