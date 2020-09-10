package mini.project.domain;

import java.sql.Date;

public class Handphone {
  private int no;
  private String name;
  private String tel;
  private Date birthday;
  private String memo;

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getName() {
    return name;
  }

  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public Date getBirthday() {
    return birthday;
  }
  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }
  public String getMemo() {
    return memo;
  }
  public void setMemo(String memo) {
    this.memo = memo;
  }
}
