package tw.noah.spring.boot.web.example.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tw.noah.spring.boot.web.example.config.BooksTransactional;
import tw.noah.spring.boot.web.example.dao.bookstore.BooksDAO;
import tw.noah.spring.boot.web.example.entity.Books;
import tw.noah.spring.boot.web.example.service.BooksService;

@Service
@BooksTransactional
public class BooksServiceImpl implements BooksService {

  @Autowired
  private BooksDAO booksDAO;

  public List<Books> findAllBooks(){
    return booksDAO.findAll();
  }

}
