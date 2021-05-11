package com.sangsoo.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * interface로 작성
 * JpaRepository<Entity.class, PK type>를 상속받고, JpaRepository에 없는 메소드는 만든다. -> 만드는 방법으로는 쿼리작성,
 * */
public interface PostsRepository extends JpaRepository<Posts, Long> {

    // SpringDataJpa에서 제공하지 않는 메소드를 작성한다.
    // @Query로 쿼리작성 가능.
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
