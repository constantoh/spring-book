package com.sangsoo.book.springboot.web;

import com.sangsoo.book.springboot.service.posts.PostsService;
import com.sangsoo.book.springboot.web.dto.PostsResponseDto;
import com.sangsoo.book.springboot.web.dto.PostsSaveRequestDto;
import com.sangsoo.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @RequestBody -> request가 객체형태로 넘어온다.
 *
 * @PathVariable -> url에 {}가 param으로 받아진다.
 *
 *
 * */
@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        System.out.println("requestDto = " + requestDto.toString());

        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}
