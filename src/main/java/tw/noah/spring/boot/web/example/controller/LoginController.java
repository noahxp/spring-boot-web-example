package tw.noah.spring.boot.web.example.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tw.noah.spring.boot.web.example.exception.DataNotFoundException;

@Controller
@Log4j2
@RequestMapping("/login")
public class LoginController {


  // default page , without value
  @RequestMapping(method = RequestMethod.GET)
  public String login(){

    return "index";
  }

  @RequestMapping(value="/check",method = RequestMethod.POST)
  public String loginCheck(@ModelAttribute(name="username") String userName, @ModelAttribute(name="password") String password){
    if ("joe".equals(userName)){
      throw new DataNotFoundException();
    }

    log.info(userName);
    log.info(password);

    return "redirect:/member/welcome";
  }
}
