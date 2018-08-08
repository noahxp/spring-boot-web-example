package tw.noah.spring.boot.web.example.service.impl;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tw.noah.spring.boot.web.example.config.CompanyTransactional;
import tw.noah.spring.boot.web.example.dao.company.EmployeeDAO;
import tw.noah.spring.boot.web.example.entity.Employee;
import tw.noah.spring.boot.web.example.service.EmployeeService;

@Service
@CompanyTransactional
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeDAO employeeDAO;

  @Override
  @PreDestroy
  public List<Employee> getAllEmployee() {
    return employeeDAO.findAll();
  }
}
