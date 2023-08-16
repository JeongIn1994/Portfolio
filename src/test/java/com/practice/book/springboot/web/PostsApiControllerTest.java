package com.practice.book.springboot.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.practice.book.springboot.domain.posts.Posts;
import com.practice.book.springboot.domain.posts.PostsRepository;
import com.practice.book.springboot.web.dto.PostsSaveRequestDto;
import com.practice.book.springboot.web.dto.PostsupdateRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

//    @BeforeEach
//    public void setup(){
//        mvc = MockMvcBuilders
//                .webAppContextSetup(context)
//                .apply(springSecurity())
//                .build();
//    }

    @AfterEach
    public void tearDown() throws Exception{
        postsRepository.deleteAll();
    }

//    @Test
//    @WithMockUser(roles = "USER")
//    public void regist_Posts() throws Exception{
//
//        String title = "title";
//        String content = "content";
//        String testUser = "testUser";
//        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
//                .title(title)
//                .content(content)
//                .user_name(testUser)
//                .build();
//
//        String url = "http://localhost:" + port + "/api/v1/posts";
//
////        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);
////
////        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
////        assertThat(responseEntity.getBody()).isGreaterThan(0L);
//        mvc.perform(post(url)
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content(new ObjectMapper().writeValueAsString(requestDto)))
//                .andExpect(status().isOk());
//
//        List<Posts> all = postsRepository.findAll();
//        assertThat(all.get(0).getTitle()).isEqualTo(title);
//        assertThat(all.get(0).getContent()).isEqualTo(content);
//    }
//    @Test
//    @WithMockUser(roles = "USER")
//    public void modify_Posts() throws Exception{
//        String testUser = "testUser";
//        Posts savePosts = postsRepository.save(Posts.builder()
//                .title("title")
//                .content("content")
//                .user_name(testUser)
//                .build());
//
//        Long updateId = savePosts.getId();
//        String expectedTitle = "title2";
//        String expectedContent = "content2";
//
//        PostsupdateRequestDto requestDto =
//                PostsupdateRequestDto.builder()
//                        .title(expectedTitle)
//                        .content(expectedContent)
//                        .build();
//
//        String url = "http://localhost:" + port + "/api/v1/posts/" + updateId;
//
//        HttpEntity<PostsupdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

//        ResponseEntity<Long> responseEntity =
//                restTemplate.exchange(url, HttpMethod.PUT,
//                requestEntity, Long.class);
//
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseEntity.getBody()).isGreaterThan(0L);

//        mvc.perform(put(url)
//                        .contentType(MediaType.APPLICATION_JSON_UTF8)
//                        .content(new ObjectMapper().writeValueAsString(requestDto)))
//                .andExpect(status().isOk());
//
//        List<Posts> all = postsRepository.findAll();
//        assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
//        assertThat(all.get(0).getContent()).isEqualTo(expectedContent);
//    }
}
