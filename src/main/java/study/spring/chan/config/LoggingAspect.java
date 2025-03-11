package study.spring.chan.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

  @Before("execution(* study.spring.chan.controller.UserController.userHome(..))")
  public void commitTransactionBefore() {
    log.info("[ AOP 작동 테스트 - Before - URL{ UserHome } ]");
  }

  @After("execution(* study.spring.chan.controller.UserController.userHome(..))")
  public void commitTransactionAfter() {
    log.info("[ AOP 작동 테스트 - After - URL{ UserHome } ]");
  }
}
