package com.kjt.book.springbook.web;

import com.kjt.book.springbook.service.posts.PostsServices;
import com.kjt.book.springbook.web.dto.PostsResponseDto;
import com.kjt.book.springbook.web.dto.PostsSaveRequestDto;
import com.kjt.book.springbook.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsServices postsServices;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {

        return postsServices.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsServices.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsServices.findById(id);
    }
}
