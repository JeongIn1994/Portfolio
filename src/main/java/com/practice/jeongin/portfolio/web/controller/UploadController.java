package com.practice.jeongin.portfolio.web.controller;

import com.practice.jeongin.portfolio.web.dto.UploadResultDTO;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
public class UploadController {

    @Value("${board.uploadUrl}")
    private String uploadBaseUrl;

    @PostMapping("/uploadAjax")
    private ResponseEntity<List<UploadResultDTO>> uploadFile(MultipartFile[] uploadFiles){

        List<UploadResultDTO> resultDTOList = new ArrayList<>();

        for (MultipartFile multipartFile : uploadFiles){

            if(!multipartFile.getContentType().startsWith("image")){
                log.warn("this file is not image file");
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
            String originName = multipartFile.getOriginalFilename();
            String fileName = originName.substring(originName.lastIndexOf("\\") + 1);

            String folderPath = makeFolder();

            log.info(folderPath);

            String uuid = UUID.randomUUID().toString();

            String saveName = uploadBaseUrl + File.separator + folderPath + File.separator + uuid + "_" + fileName;

            Path savePath = Paths.get(saveName);

            try{
                multipartFile.transferTo(savePath);

                String thumbnailSaveName = uploadBaseUrl + File.separator + folderPath + File.separator
                        + "s_" + uuid + "_" + fileName;

                File thumbnailFile = new File(thumbnailSaveName);

                Thumbnailator.createThumbnail(savePath.toFile(), thumbnailFile, 100, 100);
                resultDTOList.add(new UploadResultDTO(fileName,uuid, folderPath));
            } catch (IOException e) {
                log.error(e);
            }
        }
        return new ResponseEntity<>(resultDTOList, HttpStatus.OK);
    }
    @PostMapping("/summaryUploadAjax")
    private ResponseEntity<String> uploadSummaryFile(MultipartFile uploadFiles){

        if(!uploadFiles.getContentType().startsWith("image")){
            log.warn("this file is not image file");
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        return ResponseEntity.ok("File uploaded successfully!");
    }

    @GetMapping("/display")
    public ResponseEntity<byte[]> getFile(String fileName){
        ResponseEntity<byte[]> result;

        try{
            String srcFileName = URLDecoder.decode(fileName, StandardCharsets.UTF_8);

            log.info("fileName:" + srcFileName);

            File file = new File(uploadBaseUrl + File.separator + srcFileName);

            log.info("file:" + file);

            HttpHeaders headers = new HttpHeaders();

            headers.add("Content-Type", Files.probeContentType(file.toPath()));

            result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);

        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }

    @PostMapping("/removeFile")
    public ResponseEntity<Boolean> removeFile (String fileName){

        String srcFileName = null;

        srcFileName = URLDecoder.decode(fileName, StandardCharsets.UTF_8);

        File file = new File(uploadBaseUrl + File.separator + srcFileName);
        boolean result = file.delete();

        File thumbnail = new File(file.getParent(), "s_" + file.getName());

        result = thumbnail.delete();

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    private String makeFolder(){

        String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        String folderPath = str.replace("/" , File.separator);

        File uploadPathFolder = new File(uploadBaseUrl, folderPath);

        if(!uploadPathFolder.exists()){
            uploadPathFolder.mkdirs();
        }

        return str;
    }

}
