package tw.noah.spring.boot.web.example.entity;

import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sell_item")
public class SellItem {

  private int sellItemId;
  private String itemName;
  private short unitPrice;
  private String unitName;
  private Timestamp createDate;
  private Timestamp updateDate;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "sell_item_id")
  public int getSellItemId() {
    return sellItemId;
  }

  public void setSellItemId(int sellItemId) {
    this.sellItemId = sellItemId;
  }

  @Basic
  @Column(name = "item_name")
  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  @Basic
  @Column(name = "unit_price")
  public short getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(short unitPrice) {
    this.unitPrice = unitPrice;
  }

  @Basic
  @Column(name = "unit_name")
  public String getUnitName() {
    return unitName;
  }

  public void setUnitName(String unitName) {
    this.unitName = unitName;
  }

  @Basic
  @Column(name = "create_date")
  public Timestamp getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Timestamp createDate) {
    this.createDate = createDate;
  }

  @Basic
  @Column(name = "update_date")
  public Timestamp getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Timestamp updateDate) {
    this.updateDate = updateDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SellItem sellItem = (SellItem) o;
    return sellItemId == sellItem.sellItemId && unitPrice == sellItem.unitPrice && Objects.equals(itemName, sellItem.itemName) && Objects
        .equals(unitName, sellItem.unitName) && Objects.equals(createDate, sellItem.createDate) && Objects.equals(updateDate, sellItem.updateDate);
  }

  @Override
  public int hashCode() {

    return Objects.hash(sellItemId, itemName, unitPrice, unitName, createDate, updateDate);
  }
}
