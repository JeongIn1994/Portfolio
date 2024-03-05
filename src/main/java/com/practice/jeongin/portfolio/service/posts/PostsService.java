package com.practice.jeongin.portfolio.service.posts;

import com.practice.jeongin.portfolio.domain.posts.Posts;
import com.practice.jeongin.portfolio.domain.posts.PostsRepository;
import com.practice.jeongin.portfolio.web.dto.PostsListResponseDto;
import com.practice.jeongin.portfolio.web.dto.PostsResponseDto;
import com.practice.jeongin.portfolio.web.dto.PostsSaveRequestDto;
import com.practice.jeongin.portfolio.web.dto.PostsupdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsupdateRequestDto requestDto){
        Posts posts =
                postsRepository.findById(id)
                        .orElseThrow(()-> new IllegalArgumentException("Not Found Posts!"));
        posts.update(requestDto.getTitle(), requestDto.getContent(),
                requestDto.getLanguage(), requestDto.getSummary(),
                requestDto.getStart_date(), requestDto.getEnd_date(),
                requestDto.getProgress());

        return id;

    }

    public PostsResponseDto findById (Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not Found Posts!"));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> finAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Posts Was Not Exist! ID=" + id));

        postsRepository.delete(posts);
    }

    public List<Map<String, Object>> getCurrent3Language(){
        PageRequest pageable = PageRequest.of(0,3);

        List<Object[]> languageCounts = postsRepository.getCurrent3Language(pageable);
        List<Map<String, Object>> processedData = new ArrayList<>();
        for (Object[] objArray : languageCounts) {
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("language", objArray[0]);
            dataMap.put("count", objArray[1]);
            processedData.add(dataMap);
        }

        return processedData;
    }

}
