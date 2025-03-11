package study.spring.chan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration // 설정 클래스임을 명시
public class CustomUserDetailsService {

  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails user = User.withUsername("user")
        .password("{noop}password") // {noop}: 암호화 미적용
        .roles("USER")
        .build();

    return new InMemoryUserDetailsManager(user);
  }
}