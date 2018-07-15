package tw.noah.spring.boot.web.example.controller;

import java.util.List;
import javax.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tw.noah.spring.boot.web.example.entity.Books;
import tw.noah.spring.boot.web.example.entity.Employee;
import tw.noah.spring.boot.web.example.model.User;
import tw.noah.spring.boot.web.example.service.BooksService;
import tw.noah.spring.boot.web.example.service.EmployeeService;

@Controller
@Log4j2
@RequestMapping("/member")
public class MemberContoller {

  @Resource
  private BooksService booksService;

  @Resource
  private EmployeeService employeeService;

  @RequestMapping(value = "/welcome",method = RequestMethod.GET)
  public String memberHome(Model m){
    User user = new User();
    user.setFirstName("noah");
    user.setFamilyName("liu");
    user.setAge(18);

    m.addAttribute(user);

    List<Books> booksList = booksService.findAllBooks();
    m.addAllAttributes(booksList);

    List<Employee> employeeList = employeeService.getAllEmployee();
    m.addAllAttributes(employeeList);

    return "memberList";
  }
}
