package study.spring.chan.JWT;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.util.Date;

public class JWTBuilder {

  // 복호화 키 설정
  private static final String SECRET_KEY = "restoreKey";

  public String createJWT() {
    // 서명에 사용할 키 생성
    Key signingKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

    // 만료 시간 설정 (3분 후)
    Date expiration = Date.from(Instant.now().plusSeconds(180));

    // JWT 생성
    String jwt = Jwts.builder()
        .header()                                // (2) Optional: 헤더 설정 시작
        .keyId("aKeyId")                     // 헤더에 Key ID 설정
        .and()                                  // 헤더 설정 완료 후 빌더로 돌아감
        .subject("Bob")                           // (3) 페이로드: Subject 설정
        .setExpiration(expiration)                // 만료 시간 설정
        .signWith(signingKey, SignatureAlgorithm.HS256) // (4) 서명 설정
        .compact();                               // (5) 최종 JWT 문자열 생성

    return jwt;
  }
}
