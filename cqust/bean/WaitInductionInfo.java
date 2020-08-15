package cn.edu.cqust.bean;

/**
 * @project: HRMS
 * @author: Tang.F.C
 * @date: 2020-08-12 11:52
 * @desc:
 */
@SuppressWarnings("unused")
public class WaitInductionInfo {

  private Integer id;
  private String interviewQualifiedTime;
  private String state;
  private Integer stateOne;
  private String medicalQualifiedTime;
  private String delayTime;
  private String note;
  private Integer customerId;
  private Integer phoneCallListId;
  private Integer employeeId;
  private CustomerInfo customer;
  private PhoneCallList phoneCallList;
  private Employee employee;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getInterviewQualifiedTime() {
    return interviewQualifiedTime;
  }

  public void setInterviewQualifiedTime(String interviewQualifiedTime) {
    this.interviewQualifiedTime = interviewQualifiedTime;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public String getMedicalQualifiedTime() {
    return medicalQualifiedTime;
  }

  public void setMedicalQualifiedTime(String medicalQualifiedTime) {
    this.medicalQualifiedTime = medicalQualifiedTime;
  }


  public String getDelayTime() {
    return delayTime;
  }

  public void setDelayTime(String delayTime) {
    this.delayTime = delayTime;
  }


  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }


  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }


  public Integer getPhoneCallListId() {
    return phoneCallListId;
  }

  public void setPhoneCallListId(Integer phoneCallListId) {
    this.phoneCallListId = phoneCallListId;
  }


  public Integer getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Integer employeeId) {
    this.employeeId = employeeId;
  }

  public CustomerInfo getCustomer() {
    return customer;
  }

  public void setCustomer(CustomerInfo customer) {
    this.customer = customer;
  }

  public PhoneCallList getPhoneCallList() {
    return phoneCallList;
  }

  public void setPhoneCallList(PhoneCallList phoneCallList) {
    this.phoneCallList = phoneCallList;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public Integer getStateOne() {
    return stateOne;
  }

  public void setStateOne(Integer stateOne) {
    this.stateOne = stateOne;
  }
}
