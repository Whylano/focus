package com.example.sparta.controller;

import com.example.sparta.dto.*;
import com.example.sparta.service.PostService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
@RestController // json형식으로 (데이터로)
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {

    private final PostService postService;


    //게시글 전체 조회
    @GetMapping("/posts")//내가 GET이 경로(/posts)로 오는 것을 맡아서 처리하겠다른 뜻
    public List<PostResDto> getAll() {

        return postService.getAll(); // Service에게 다 가져와라고 요청한 것
    }

    //게시글 단건 조회
    @GetMapping("/posts/{id}")//내가 GET이 경로(/posts)로 오는 것을 맡아서 처리하겠다른 뜻
    public PostResDto getOneById(@PathVariable("id") Long id) { //(url에서 받아온)id를 @PathVariable로 
                                                                // 받아온다 (@PathVariable=경로변수) 그리고 Long id에 저장이된다.
        return postService.getOne(id); //Service에서 하나를 들고 오고
    }
    //id :{asd}, asda:
    // 게시글 생성
    // Http body에 데이터가 담겨있다.
    @PostMapping("/posts")//내가 POST이 경로(/posts)로 오는 것을 맡아서 처리하겠다른 뜻
    public PostResDto createPost(@RequestBody PostReqDto postReqDto) { //@RequestBody에서 바디의 값을 가져온다.

        return postService.create(postReqDto);//PostReqDto자료를 받아와서 Service에 요청하는 것

    }

    //비밀번호를 확인하기 - 확인하고자 하는 비밀번호(HTTP BODY에 담겨있다), 게시글 id(url로 받아온다)
    // Http body에 데이터가 담겨있다.
    @PostMapping("/posts/{id}")
    public PasswordCheckResDto passwordCheck(@PathVariable("id") Long id, @RequestBody PasswordCheckReqDto passwordCheckReqDto) {

        return postService.passwordCheck(id, passwordCheckReqDto);

    }

    // 게시글 수정
    // 게시글 id, 바꿀 데이터가 필요
    @PutMapping("/posts/{id}") //받아오는 것이 url이면 @PathVariable,받아오는 경로가 HTTPBody면 @RequestBody
    public PostResDto updatePost(@PathVariable("id") Long id, @RequestBody PostReqDto postReqDto) {

        return postService.update(id, postReqDto);

    }

    // 게시글 삭제
    @DeleteMapping("/posts/{id}")
    public PostDeleteResDto deletePost(@PathVariable("id") Long id) {

        return postService.delete(id);
    }
}
//    @DeleteMapping("/posts/{id}")
//    public Long deletePosts(@PathVariable Long id) {
//        postRepository.deleteById(id);
//        return id;


