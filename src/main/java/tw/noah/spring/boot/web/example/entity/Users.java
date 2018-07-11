package tw.noah.spring.boot.web.example.entity;

import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {

  private int usersId;
  private String firstName;
  private String familyName;
  private short age;
  private Timestamp createDate;
  private Timestamp updateDate;

  @Id
  @Column(name = "users_id")
  public int getUsersId() {
    return usersId;
  }

  public void setUsersId(int usersId) {
    this.usersId = usersId;
  }

  @Basic
  @Column(name = "first_name")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Basic
  @Column(name = "family_name")
  public String getFamilyName() {
    return familyName;
  }

  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

  @Basic
  @Column(name = "age")
  public short getAge() {
    return age;
  }

  public void setAge(short age) {
    this.age = age;
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
    Users users = (Users) o;
    return usersId == users.usersId && age == users.age && Objects.equals(firstName, users.firstName) && Objects.equals(familyName, users.familyName)
        && Objects.equals(createDate, users.createDate) && Objects.equals(updateDate, users.updateDate);
  }

  @Override
  public int hashCode() {

    return Objects.hash(usersId, firstName, familyName, age, createDate, updateDate);
  }
}
