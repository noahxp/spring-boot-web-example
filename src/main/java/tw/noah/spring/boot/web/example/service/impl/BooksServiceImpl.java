package tw.noah.spring.boot.web.example.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tw.noah.spring.boot.web.example.dao.bookstore.BooksDAO;
import tw.noah.spring.boot.web.example.entity.Books;
import tw.noah.spring.boot.web.example.service.BooksService;

@Service
//@Transactional(value = )
@EnableTransactionManagement
public class BooksServiceImpl implements BooksService {

//  @Resource
  @Autowired
  private BooksDAO booksDAO;

  public List<Books> findAllSellItem(){
    return booksDAO.findAll();
  }

}
