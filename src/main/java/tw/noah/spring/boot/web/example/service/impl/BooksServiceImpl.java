package tw.noah.spring.boot.web.example.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.noah.spring.boot.web.example.dao.SellItemDAO;
import tw.noah.spring.boot.web.example.entity.books.SellItem;
import tw.noah.spring.boot.web.example.service.BooksService;

@Service
@Transactional("booksTx")
public class BooksServiceImpl implements BooksService {

  @Resource
  private SellItemDAO sellItemDAO;

  public List<SellItem> findAllSellItem(){
    return sellItemDAO.findAll();
  }

  public List<SellItem> findByItemPriceGraterThan(int itemPrice){
    return sellItemDAO.findByUnitPriceGreaterThan(itemPrice);
  }
}
