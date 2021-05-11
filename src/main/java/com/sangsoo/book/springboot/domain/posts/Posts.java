package com.sangsoo.book.springboot.domain.posts;

import com.sangsoo.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Getter -> getter메소드 생성(lombok)
 *  -Setter를 작성하지 않음 -> setStatus (X), update(O)
 * NoArgsConstructor -> 기본 생성자 생성(lombok)
 *
 * Entity ->실제 DB table과 매칭될 클래스, Entity클래스(javax)
 *          -> Posts table생성됨.
 *
 * Id -> key(javax)
 * Column(javax)
 *
 * Builder -> Builder패턴(lombok)
 *
 * extends BaseTimeEntity ->
 * */
@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
