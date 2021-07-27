package com.kjt.book.springbook.service.posts;

import com.kjt.book.springbook.domain.posts.Posts;
import com.kjt.book.springbook.domain.posts.PostsRepository;
import com.kjt.book.springbook.web.dto.PostsResponseDto;
import com.kjt.book.springbook.web.dto.PostsSaveRequestDto;
import com.kjt.book.springbook.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsServices {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).
                orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다 id="+id));

        return new PostsResponseDto(entity);
    }
}
