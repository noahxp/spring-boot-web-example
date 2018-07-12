package tw.noah.spring.boot.web.example.service;

import java.util.List;
import tw.noah.spring.boot.web.example.entity.books.SellItem;

public interface BooksService {
  List<SellItem> findAllSellItem();
  List<SellItem> findByItemPriceGraterThan(int itemPrice);
}
