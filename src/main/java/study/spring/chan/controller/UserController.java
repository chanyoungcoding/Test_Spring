package study.spring.chan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import study.spring.chan.domain.UserDTO;

@Slf4j
@Controller
public class UserController {

  @GetMapping("/user")
  public String userHome(Model model) {
    log.info("----------- user URL START -----------");
    UserDTO user = new UserDTO("찬영", 13);
    model.addAttribute("user", user);
    return "/user/home";
  }
}
