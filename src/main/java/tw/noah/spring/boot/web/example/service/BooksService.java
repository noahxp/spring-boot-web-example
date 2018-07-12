package tw.noah.spring.boot.web.example.service;

import java.util.List;
import tw.noah.spring.boot.web.example.entity.SellItem;

public interface BooksService {
  public List<SellItem> findAllSellItem();
  List<SellItem> findByItemPriceGraterThan(int itemPrice);
}
