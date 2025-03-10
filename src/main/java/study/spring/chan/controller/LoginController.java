package study.spring.chan.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import study.spring.chan.domain.LoginDTO;

@Controller
public class LoginController {

  @GetMapping("/login")
  public String login() {
    return "/login/home";
  }

  @PostMapping("/login")
  public String loginPost(@ModelAttribute LoginDTO data, HttpServletRequest req) {
    HttpSession session = req.getSession();
    return "redirect:/login/home";
  }
}
