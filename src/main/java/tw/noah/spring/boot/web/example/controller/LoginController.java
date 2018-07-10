package tw.noah.spring.boot.web.example.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Log4j2
@RequestMapping("/login")
public class LoginController {


  @RequestMapping(value="/" , method = RequestMethod.GET)
  public String login(){
    log.info("go");
    return "index";
  }

  @RequestMapping(value="/check",method = RequestMethod.POST)
  public String loginCheck(){
    return "redirect:/member/welcome";
  }
}
