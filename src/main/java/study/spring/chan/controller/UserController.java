package study.spring.chan.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import study.spring.chan.domain.UserDTO;
import study.spring.chan.service.UserService;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/user")
  public String userHome(Model model) {
    log.info("----------- user URL START -----------");
    UserDTO user = new UserDTO("찬영", 13);
    model.addAttribute("user", user);
    return "/user/home";
  }

  @GetMapping("/user/{userId}")
  public String findUser(@PathVariable String userId) {

    return "/user/findUser";
  }
}
