package study.spring.chan.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    return "user/home";
  }

  @PostMapping("/user/create")
  public String createUser(@RequestParam String username, @RequestParam int age, Model model) {
    try {
      UserDTO user = userService.createUser(username, age);
      model.addAttribute("user", user);
      return "user/home";
    } catch (IllegalArgumentException e) {
      model.addAttribute("error", e.getMessage());
      return "user/home";
    }
  }

  @GetMapping("/user/{username}")
  public String findUserName(@PathVariable String username) {

    return "/user/findUser";
  }

  // 사용자 조회 처리 ( POST )
  @PostMapping("/user/find")
  public  String findUser(@RequestParam String username, Model model) {
    UserDTO user = userService.findUser(username);

    if(user != null) {
      model.addAttribute("user", user);
      return "user/userDetail";
    } else {
      model.addAttribute("error", "사용자 정보가 없습니다.");
      return "user/findUser";
    }
  }

  // 사용자 삭제
  @DeleteMapping("/user/delete")
  public String deleteUser(@RequestParam String username, Model model) {
    userService.deleteUser(username);
    model.addAttribute("message", username + "삭제되었습니다.");
    return "user/findUser";
  }
}
