package study.spring.chan.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import study.spring.chan.domain.UserDTO;
import study.spring.chan.service.UserService;

import java.util.Collection;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/user")
  public String userHome(Model model) {
    log.info("----------- user URL START -----------");
    Collection<UserDTO> users = userService.findAllUser();
    model.addAttribute("user", users);
    return "user/home";
  }

  @PostMapping("/user")
  public String createUser(@RequestParam String username, @RequestParam int age, Model model) {

    String url = "redirect:/user/home";

    try {
      UserDTO user = userService.createUser(username, age);
      model.addAttribute("user", user);
      return url;
    } catch (IllegalArgumentException e) {
      model.addAttribute("error", e.getMessage());
      return url;
    }
  }

  @GetMapping("/user/{username}")
  public String findUserName(@PathVariable String username, Model model) {
    UserDTO user = userService.findUser(username);
    model.addAttribute("user", user);
    return "/user/findUser";
  }

  // 사용자 업데이트
  @PutMapping("/user")
  public String updateUserAge(@ModelAttribute UserDTO userDTO, Model model) {
    UserDTO user = userService.updateUserAge(userDTO.getUserName(), userDTO.getAge());
    model.addAttribute("user", user);
    return "redirect:/user/findUser";
  }

  // 사용자 삭제
  @DeleteMapping("/user")
  public String deleteUser(@RequestParam String username, Model model) {
    userService.deleteUser(username);
    model.addAttribute("message", username + "삭제되었습니다.");
    return "redirect:/user/home";
  }
}
