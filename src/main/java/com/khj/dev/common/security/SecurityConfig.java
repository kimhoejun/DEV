package com.khj.dev.common.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	/*
	 * 스프링 부트 프로젝트에 Spring Security 의존성이 포함되어 있거나, spring-boot-starter-security가
	 * 자동으로 설정되면 다음과 같은 보안 설정이 기본으로 적용됩니다:
	 * 모든 엔드포인트는 인증 없이는 접근 불가
	 * 인증되지 않은 요청은 /login 페이지로 리다이렉트
	 * 결과적으로 HTML 로그인 페이지가 반환됨
	 */
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeHttpRequests(authz -> authz
                .anyRequest().permitAll()
            );

        return http.build();
    }
}
