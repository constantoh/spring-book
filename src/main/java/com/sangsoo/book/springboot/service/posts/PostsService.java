package com.sangsoo.book.springboot.service.posts;

import com.sangsoo.book.springboot.domain.posts.Posts;
import com.sangsoo.book.springboot.domain.posts.PostsRepository;
import com.sangsoo.book.springboot.web.dto.PostsListResponseDto;
import com.sangsoo.book.springboot.web.dto.PostsResponseDto;
import com.sangsoo.book.springboot.web.dto.PostsSaveRequestDto;
import com.sangsoo.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Transactional(readOnly) -> 트랜잭션, readOnly = true면 성능상 좋다.(조회만 할때)
 *
 * update메소드에 findbyId만하고 posts.update로 객체에 값만 업데이트해줄뿐, query가 없다.
 *  -> jpa영속성. 변경된 객체값으로 데이터를 변경한다. -> 더티체킹
 * */

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Posts posts  = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        postsRepository.delete(posts);
    }
}
