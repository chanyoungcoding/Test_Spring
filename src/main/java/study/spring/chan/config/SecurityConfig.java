package study.spring.chan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http
        .csrf(csrf -> csrf.disable()) // CSRF 보호 비활성화 (API 서버일 경우)
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/mypage", "/shopping").authenticated() // 인증이 필요한 경로
            .anyRequest().permitAll() // 그 외의 모든 요청은 인증 없이 접근 가능
        )
        .formLogin(login -> login
            .loginPage("/login") // 커스텀 로그인 페이지 설정
            .defaultSuccessUrl("/mypage") // 로그인 성공 후 이동할 페이지
            .permitAll()
        )
        .logout(logout -> logout
            .logoutUrl("/logout") // 로그아웃 처리 경로
            .logoutSuccessUrl("/login") // 로그아웃 성공 후 이동할 페이지
            .permitAll()
        );

    return http.build();

  }
}
