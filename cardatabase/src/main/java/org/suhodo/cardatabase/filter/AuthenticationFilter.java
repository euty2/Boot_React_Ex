package org.suhodo.cardatabase.filter;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.suhodo.cardatabase.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
@RequiredArgsConstructor
public class AuthenticationFilter extends OncePerRequestFilter{

    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 토큰 꺼내기
        String jws = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(jws != null){        // 토큰이 존재한다면
            // 토큰 검증 및 사용자 반환
            String username = jwtService.getAuthUser(request);
            
            // 인증하기
            Authentication authEntication = 
                new UsernamePasswordAuthenticationToken(
                        username, null, java.util.Collections.emptyList());

            // 스프링 시큐리티에 인증정보를 등록
            SecurityContextHolder.getContext().setAuthentication(authEntication);
        }

        // 수신 할 다음 프로세스로 전달(다음 필터 or Controller에 전달)
        filterChain.doFilter(request, response);
    }

}
