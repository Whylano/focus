package com.example.sparta.dto;

import com.example.sparta.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Getter
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
