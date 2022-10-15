package com.example.homework1.service;

import com.example.homework1.dto.*;
import com.example.homework1.entity.Post;
import com.example.homework1.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    // 게시글 전체 조회
    public List<PostResDto> getAll(){

        //[1, 2, 3, 4, 5]
        //["1", "2", "3", "4", "5"]
        List<PostResDto> result = new ArrayList<>();

        List<Post> postList = postRepository.findAll();

        for(Post post : postList){
            PostResDto postResDto = new PostResDto(post);
            result.add(postResDto);
        }

        return result;
    }

    // 게시글 단건 조회 - id가 필요!!!!!
    public PostResDto getOne(Long id){

        Optional<Post> optionalPost = postRepository.findById(id);

        if(optionalPost.isEmpty()){
            throw new IllegalArgumentException();
        }else{
            return new PostResDto(optionalPost.get());
        }

    }

    // 게시글 저장 - 게시글 데이터가 필요!!!!!
    @Transactional

    public PostResDto create(PostReqDto postReqDto){

        Post post = postReqDto.toEntity();

        postRepository.save(post);

        return new PostResDto(post);

    }

    // 비밀번호 확인
    // 1. 확인할 게시물을 가져온다.
    // 2. 비교한다.
    public PasswordCheckResDto passwordCheck(Long id, PasswordCheckReqDto passwordCheckReqDto){

        Optional<Post> optionalPost = postRepository.findById(id);

        //값이 없다면
        if(optionalPost.isEmpty()){
            throw new IllegalArgumentException();
        }else{
            // 내부에 값이 존재하므로 값을 꺼낸다.
            Post post = optionalPost.get();

            // 비밀번호 값이 일치하는지 확인한다.
            boolean match = post.passwordMatch(passwordCheckReqDto.getPassword());

            // 원하는 리턴타입을 만든 후 리턴한다.
            return new PasswordCheckResDto(match);
        }

    }

    // 게시글 수정
    // 1. db에 저장된 수정할 게시글을 가져온다.
    // 2. 게시글을 수정한다.
    // 3. db에 수정된 게시글을 저장한다.
    public PostResDto update(Long id, PostReqDto postReqDto){

        Optional<Post> optionalPost = postRepository.findById(id);

        //게시글이 없다면
        if(optionalPost.isEmpty()){
            throw new IllegalArgumentException();
        }else{
            Post post = optionalPost.get();

            post.update(
                    postReqDto.getTitle(),
                    postReqDto.getAuthor(),
                    postReqDto.getContent(),
                    postReqDto.getPassword());

            postRepository.save(post);

            return new PostResDto(post);
        }

    }

    // 게시글 삭제
    public PostDeleteResDto delete(Long id){

        postRepository.deleteById(id);

        return new PostDeleteResDto(true);

    }



}
