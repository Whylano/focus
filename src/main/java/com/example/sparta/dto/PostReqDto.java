package com.example.sparta.dto;

import com.example.sparta.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class PostReqDto {

    private String title;

    private String author;

    private String content;

    private String password;

    // dto 를 entity로 바꿔준다.
    public Post toEntity(){

        return new Post(title, author, content, password);

    }

}
