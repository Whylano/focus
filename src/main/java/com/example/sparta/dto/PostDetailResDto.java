package com.example.homework1.dto;

import com.example.homework1.entity.Post;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

public class PostDetailResDto {

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long id;

    private String title;

    private String author;

    private String content;

    public PostDetailResDto(Post post){

        createdAt = post.getCreatedAt();

        updatedAt = post.getUpdatedAt();

        id = post.getId();

        title = post.getTitle();

        author = post.getAuthor();

        content = post.getContent();
    }
}
