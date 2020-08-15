package cn.edu.cqust.bean;

/**
 * @project: HRMS
 * @author: Tang.F.C
 * @date: 2020-08-011 15:52
 * @desc:
 */
@SuppressWarnings("unused")
public class InterviewInfo {

    private Integer id;
    private String note;
    private Integer state;
    private Integer customerId;
    private Integer phoneCallListId;
    private Integer signUpId;
    private Integer employeeId;
    private CustomerInfo customerInfo;
    private PhoneCallList phoneCallList;
    private SignUpInfo signUpInfo;
    private Employee employee;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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


    public Integer getSignUpId() {
        return signUpId;
    }

    public void setSignUpId(Integer signUpId) {
        this.signUpId = signUpId;
    }


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public PhoneCallList getPhoneCallList() {
        return phoneCallList;
    }

    public void setPhoneCallList(PhoneCallList phoneCallList) {
        this.phoneCallList = phoneCallList;
    }

    public SignUpInfo getSignUpInfo() {
        return signUpInfo;
    }

    public void setSignUpInfo(SignUpInfo signUpInfo) {
        this.signUpInfo = signUpInfo;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
                ", note='" + note +
                ", state=" + state +
                ", customerId=" + customerId +
                ", phoneCallListId=" + phoneCallListId +
                ", signUpId=" + signUpId +
                ", employeeId=" + employeeId +
                ", customerInfo=" + customerInfo +
                ", phoneCallList=" + phoneCallList +
                ", signUpInfo=" + signUpInfo +
                ", employee=" + employee +
                " ]\n";
    }
}
