package cn.edu.cqust.bean;

/**
 * @project: HRMS
 * @author: Tang.F.C
 * @date: 2020-08-05 10:52
 * @desc: 
 */
@SuppressWarnings("unused")
public class Employee {

  private Integer id;
  private Integer idWork;
  private String name;
  private Integer idNumber;
  private String gender;
  private String phone;
  private String inductionTime;
  private String deptName;
  private String password;
  private String position;
  private String state;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getIdWork() {
    return idWork;
  }

  public void setIdWork(Integer idWork) {
    this.idWork = idWork;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public Integer getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(Integer idNumber) {
    this.idNumber = idNumber;
  }


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getInductionTime() {
    return inductionTime;
  }

  public void setInductionTime(String inductionTime) {
    this.inductionTime = inductionTime;
  }


  public String getDeptName() {
    return deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  @Override
  public String toString() {
    return "Employee{" +
            "id=" + id +
            ", idWork=" + idWork +
            ", name='" + name + '\'' +
            ", idNumber=" + idNumber +
            ", gender='" + gender + '\'' +
            ", phone='" + phone + '\'' +
            ", inductionTime='" + inductionTime + '\'' +
            ", deptName='" + deptName + '\'' +
            ", password='" + password + '\'' +
            ", position='" + position + '\'' +
            ", state='" + state + '\'' +
            '}';
  }
}
