package com.example.homework1.dto;

import com.example.homework1.entity.Post;

import java.time.LocalDateTime;

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
