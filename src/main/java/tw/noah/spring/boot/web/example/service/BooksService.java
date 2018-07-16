package tw.noah.spring.boot.web.example.service;

import java.util.List;
import tw.noah.spring.boot.web.example.entity.Books;

public interface BooksService {
  List<Books> findAllBooks();

}
