package com.example.homework1.dto;

import com.example.homework1.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
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
