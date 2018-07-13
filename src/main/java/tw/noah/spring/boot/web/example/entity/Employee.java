package tw.noah.spring.boot.web.example.entity;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

  private int employeeId;
  private String empNo;
  private Date birthday;
  private String firstName;
  private String lastName;
  private String gender;
  private Date arriveDate;
  private Date createDate;
  private Date updateDate;

  @Id
  @Column(name = "employee_id", nullable = false)
  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  @Basic
  @Column(name = "emp_no", nullable = false, length = 10)
  public String getEmpNo() {
    return empNo;
  }

  public void setEmpNo(String empNo) {
    this.empNo = empNo;
  }

  @Basic
  @Column(name = "birthday", nullable = false)
  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  @Basic
  @Column(name = "first_name", nullable = false, length = 20)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Basic
  @Column(name = "last_name", nullable = false, length = 30)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Basic
  @Column(name = "gender", nullable = true)
  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  @Basic
  @Column(name = "arrive_date", nullable = false)
  public Date getArriveDate() {
    return arriveDate;
  }

  public void setArriveDate(Date arriveDate) {
    this.arriveDate = arriveDate;
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

    Employee employee = (Employee) object;

    if (employeeId != employee.employeeId) {
      return false;
    }
    if (empNo != null ? !empNo.equals(employee.empNo) : employee.empNo != null) {
      return false;
    }
    if (birthday != null ? !birthday.equals(employee.birthday) : employee.birthday != null) {
      return false;
    }
    if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) {
      return false;
    }
    if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) {
      return false;
    }
    if (gender != null ? !gender.equals(employee.gender) : employee.gender != null) {
      return false;
    }
    if (arriveDate != null ? !arriveDate.equals(employee.arriveDate) : employee.arriveDate != null) {
      return false;
    }
    if (createDate != null ? !createDate.equals(employee.createDate) : employee.createDate != null) {
      return false;
    }
    if (updateDate != null ? !updateDate.equals(employee.updateDate) : employee.updateDate != null) {
      return false;
    }

    return true;
  }

  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + employeeId;
    result = 31 * result + (empNo != null ? empNo.hashCode() : 0);
    result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (gender != null ? gender.hashCode() : 0);
    result = 31 * result + (arriveDate != null ? arriveDate.hashCode() : 0);
    result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
    result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
    return result;
  }
}
