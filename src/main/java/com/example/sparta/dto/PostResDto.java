package com.example.sparta.dto;

import com.example.sparta.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class PostResDto {

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long id;

    private String title;

    private String author;

    public PostResDto(Post post){

        createdAt = post.getCreatedAt();

        updatedAt = post.getUpdatedAt();

        id = post.getId();

        title = post.getTitle();

        author = post.getAuthor();

    }

}
