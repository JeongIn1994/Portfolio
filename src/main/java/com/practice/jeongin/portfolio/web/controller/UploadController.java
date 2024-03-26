package com.practice.jeongin.portfolio.web.controller;

import com.practice.jeongin.portfolio.web.dto.UploadResultDTO;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import java.util.UUID;

@RestController
@Log4j2
public class UploadController {

    @Value("${board.uploadUrl}")
    private String uploadBaseUrl;

    @Value("${summary.uploadUrl}")
    private String summaryUploadUrl;

    @Value("${skills.uploadUrl}")
    private String skillsUploadUrl;

    @PostMapping("/uploadAjax")
    private String uploadFile(@RequestParam final MultipartFile image){
        if(image.isEmpty()){
            return "";
        }
        String originName = image.getOriginalFilename();
        String fileName = originName.substring(originName.lastIndexOf("\\") + 1);
        log.info(fileName);

        String folderPath = makeFolder(0);

        log.info(folderPath);

        String uuid = UUID.randomUUID().toString();

        String saveName = uploadBaseUrl + File.separator + folderPath + File.separator + uuid + "_" + fileName;

        Path savePath = Paths.get(saveName);

        try {
            image.transferTo(savePath);
            return folderPath + "/" + uuid + "_" + fileName;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping(value = "/imageDisplay", produces = {MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public byte[] printEditorImage(@RequestParam final String filename){
        String fileFullpath = Paths.get(uploadBaseUrl, filename).toString();
        
        File uploadFile = new File(fileFullpath);
        if(!uploadFile.exists()){
            throw new RuntimeException();
        }
        
        try {
            return Files.readAllBytes(uploadFile.toPath());
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/summaryUploadAjax")
    private ResponseEntity<UploadResultDTO> uploadSummaryFile(MultipartFile uploadFile) {

        if (uploadFile == null || uploadFile.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if(!uploadFile.getContentType().startsWith("image")){
            log.warn("this file is not an image file");
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        String originName = uploadFile.getOriginalFilename();
        String fileName = originName.substring(originName.lastIndexOf("\\") + 1);

        String folderPath = makeFolder(1);

        log.info(folderPath);

        String uuid = UUID.randomUUID().toString();

        String saveName = summaryUploadUrl + File.separator + folderPath + File.separator + uuid + "_" + fileName;

        Path savePath = Paths.get(saveName);

        try{
            uploadFile.transferTo(savePath);

            String thumbnailSaveName = summaryUploadUrl + File.separator + folderPath + File.separator
                    + "s_" + uuid + "_" + fileName;

            File thumbnailFile = new File(thumbnailSaveName);

            Thumbnailator.createThumbnail(savePath.toFile(), thumbnailFile, 100, 100);
            UploadResultDTO resultDTO = new UploadResultDTO(fileName, uuid, folderPath);
            return new ResponseEntity<>(resultDTO, HttpStatus.OK);
        } catch (IOException e) {
            log.error(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/utilsFileUploadAjax")
    private ResponseEntity<UploadResultDTO> uploadSkillsFile(@RequestParam("file") MultipartFile uploadFile) {

        if (uploadFile == null || uploadFile.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if(!uploadFile.getContentType().startsWith("image")){
            log.warn("this file is not an image file");
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        String originName = "frontEnd.png";
        String fileName = originName.substring(originName.lastIndexOf("\\") + 1);


        log.info("SkillsFilePath:"+skillsUploadUrl);

        String uuid = UUID.randomUUID().toString();

        String saveName = skillsUploadUrl + File.separator + File.separator + fileName;

        Path savePath = Paths.get(saveName);

        try{
            uploadFile.transferTo(savePath);

            UploadResultDTO resultDTO = new UploadResultDTO(fileName, uuid, skillsUploadUrl);
            return new ResponseEntity<>(resultDTO, HttpStatus.OK);
        } catch (IOException e) {
            log.error(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/display")
    public ResponseEntity<byte[]> getFile(String fileName){
        ResponseEntity<byte[]> result;

        try{
            String srcFileName = URLDecoder.decode(fileName, StandardCharsets.UTF_8);

            log.info("fileName:" + srcFileName);

            File file = new File(summaryUploadUrl + File.separator + srcFileName);

            log.info("file:" + file);

            HttpHeaders headers = new HttpHeaders();

            headers.add("Content-Type", Files.probeContentType(file.toPath()));

            result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);

        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }
    @GetMapping("/display/skills")
    public ResponseEntity<byte[]> getSkillsFile(String fileName){
        ResponseEntity<byte[]> result;

        try{
            String srcFileName = URLDecoder.decode(fileName, StandardCharsets.UTF_8);

            log.info("fileName:" + srcFileName);

            File file = new File(skillsUploadUrl + File.separator + srcFileName);

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

        File file = new File(summaryUploadUrl + File.separator + srcFileName);
        boolean result = file.delete();

        File thumbnail = new File(file.getParent(), "s_" + file.getName());

        result = thumbnail.delete();

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    private String makeFolder(int index){

        String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        String folderPath = str.replace("/" , File.separator);

        if(index == 0 ){
            if(!new File(uploadBaseUrl, folderPath).exists()){
                new File(uploadBaseUrl, folderPath).mkdirs();
            }
        }else if (index == 1){
            if(!new File(summaryUploadUrl, folderPath).exists()){
                new File(summaryUploadUrl, folderPath).mkdirs();
            }
        }

        return str;
    }

}
