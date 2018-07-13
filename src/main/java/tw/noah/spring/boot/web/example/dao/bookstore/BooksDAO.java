package tw.noah.spring.boot.web.example.dao.bookstore;

import org.springframework.data.jpa.repository.JpaRepository;
import tw.noah.spring.boot.web.example.entity.Books;

/**
 * spring data jpa reference document : https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
 */
public interface BooksDAO extends JpaRepository<Books,Long> {

}
