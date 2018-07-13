package tw.noah.spring.boot.web.example.dao.company;

import org.springframework.data.jpa.repository.JpaRepository;
import tw.noah.spring.boot.web.example.entity.Employee;

/**
 * spring data jpa reference document : https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
 */
public interface EmployeeDAO extends JpaRepository<Employee,Long> {

}
