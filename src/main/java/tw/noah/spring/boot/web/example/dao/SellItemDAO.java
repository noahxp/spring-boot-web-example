package tw.noah.spring.boot.web.example.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tw.noah.spring.boot.web.example.entity.SellItem;

@Repository
public interface SellItemDAO extends JpaRepository {
//  List<SellItem> findByItempriceGranterThan(int itemPrice);
}
