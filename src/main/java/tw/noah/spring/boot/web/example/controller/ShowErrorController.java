package tw.noah.spring.boot.web.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShowErrorController {
  @RequestMapping(value="/errors" ,method = RequestMethod.GET)
  public String error(){
    int c = 0/0;
    return null;
  }
}
