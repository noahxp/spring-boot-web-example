package tw.noah.spring.boot.web.example.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Log4j2
@RequestMapping("/member")
public class MemberContoller {

  @RequestMapping(value = "/welcome",method = RequestMethod.GET)
  public String memberHome(){
    return "memberList";
  }
}
