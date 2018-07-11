package tw.noah.spring.boot.web.example.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tw.noah.spring.boot.web.example.model.User;

@Controller
@Log4j2
@RequestMapping("/member")
public class MemberContoller {

  @RequestMapping(value = "/welcome",method = RequestMethod.GET)
  public String memberHome(Model m){
    User user = new User();
    user.setFirstName("noah");
    user.setFamilyName("liu");
    user.setAge(18);

    m.addAttribute(user);

    return "memberList";
  }
}
