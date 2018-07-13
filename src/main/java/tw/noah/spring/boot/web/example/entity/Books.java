package tw.noah.spring.boot.web.example.entity;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Books {

  private int booksId;
  private String isdn;
  private String booksName;
  private Date createDate;
  private Date updateDate;

  @Id
  @Column(name = "books_id", nullable = false )
  public int getBooksId() {
    return booksId;
  }

  public void setBooksId(int booksId) {
    this.booksId = booksId;
  }

  @Basic
  @Column(name = "isdn", nullable = false, length = 20)
  public String getIsdn() {
    return isdn;
  }

  public void setIsdn(String isdn) {
    this.isdn = isdn;
  }

  @Basic
  @Column(name = "books_name", nullable = false, length = 30)
  public String getBooksName() {
    return booksName;
  }

  public void setBooksName(String booksName) {
    this.booksName = booksName;
  }

  @Basic
  @Column(name = "create_date", nullable = false)
  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  @Basic
  @Column(name = "update_date", nullable = true)
  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    if (!super.equals(object)) {
      return false;
    }

    Books books = (Books) object;

    if (booksId != books.booksId) {
      return false;
    }
    if (isdn != null ? !isdn.equals(books.isdn) : books.isdn != null) {
      return false;
    }
    if (booksName != null ? !booksName.equals(books.booksName) : books.booksName != null) {
      return false;
    }
    if (createDate != null ? !createDate.equals(books.createDate) : books.createDate != null) {
      return false;
    }
    if (updateDate != null ? !updateDate.equals(books.updateDate) : books.updateDate != null) {
      return false;
    }

    return true;
  }

  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + booksId;
    result = 31 * result + (isdn != null ? isdn.hashCode() : 0);
    result = 31 * result + (booksName != null ? booksName.hashCode() : 0);
    result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
    result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
    return result;
  }
}
