package com.practice.book.springboot.service.posts;

import com.practice.book.springboot.domain.posts.Posts;
import com.practice.book.springboot.domain.posts.PostsRepository;
import com.practice.book.springboot.web.dto.PostsResposeDto;
import com.practice.book.springboot.web.dto.PostsSaveRequestDto;
import com.practice.book.springboot.web.dto.PostsupdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;

    }

    public PostsResposeDto findById (Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not Found Posts!"));

        return new PostsResposeDto(entity);
    }
}
