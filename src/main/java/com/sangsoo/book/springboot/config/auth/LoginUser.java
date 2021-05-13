package com.sangsoo.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * User define Annotation
 *
 * ElementType.PARAMETER -> 메소드의 인자로 사용
 *
 * RetentionPolicy.RUNTIME -> 런타임환경에서 접근 가능
 * */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {

}
