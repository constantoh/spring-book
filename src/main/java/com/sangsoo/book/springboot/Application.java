package com.sangsoo.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*
* Application class -> 프로젝트의 메인 클래스
*
* @SpringBootApplication -> 스프링부트의 자동설정, bean설정 => 프로젝트의 최상단에 위치해야함.
*
* SpringApplication.run -> 내장 WAS를 실행
*
* EnableJpaAuditing -> JPA auditing 활성화
* */
//@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
