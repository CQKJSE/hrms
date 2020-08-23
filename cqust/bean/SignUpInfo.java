package cn.edu.cqust.bean;

/**
 * @project: HRMS
 * @author: Tang.F.C
 * @date: 2020-08-05 10:52
 * @desc:
 */
@SuppressWarnings("unused")
public class SignUpInfo {

    private Integer id;
    private String signUpTime;
    private String interviewTime;
    private String note;
    private Integer state;
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


    public String getSignUpTime() {
        return signUpTime;
    }

    public void setSignUpTime(String signUpTime) {
        this.signUpTime = signUpTime;
    }


    public String getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(String interviewTime) {
        this.interviewTime = interviewTime;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "[" +
                "id=" + id +
                ", signUpTime='" + signUpTime +
                ", interviewTime='" + interviewTime +
                ", note='" + note +
                ", state='" + state +
                ", customerId=" + customerId +
                ", phoneCallListId=" + phoneCallListId +
                ", employeeId=" + employeeId +
                ", customer=" + customer +
                ", phoneCallList=" + phoneCallList +
                ", employee=" + employee +
                " ]\n";
    }
}
