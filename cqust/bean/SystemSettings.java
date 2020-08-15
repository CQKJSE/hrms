package cn.edu.cqust.bean;

/**
 * @project: HRMS
 * @author: Tang.F.C
 * @date: 2020-08-08 10:54
 * @desc:
 */
@SuppressWarnings("unused")
public class SystemSettings {

  private Integer id;
  private String item;
  private String value;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }


  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

}
