package tw.noah.spring.boot.web.example.service;

import java.util.List;
import tw.noah.spring.boot.web.example.entity.Employee;

public interface EmployeeService {
  List<Employee> getAllEmployee();
}
