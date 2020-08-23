package cn.edu.cqust.bean.vo;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-13 17:01
 * @desc: /interviewListAll
 **/
@SuppressWarnings("unused")
public class RoInterviewListAll {
    private Integer interviewInfoId;
    private String customerName;
    private String idNumber;
    private String gender;
    private Integer age;
    private String phoneNumber;
    private String education;
    private String address;
    private String professionalSkills;
    private Integer hasCertificate;
    private Integer isDisability;
    private String recommendEnterprise;
    private String recommendJob;
    private String interviewTime;
    private String deptName;
    private String employeeName;
    private Integer customerId;
    private Integer signUpId;
    private Integer phoneCallListId;
    private Integer employeeId;

    public Integer getInterviewInfoId() {
        return interviewInfoId;
    }

    public void setInterviewInfoId(Integer interviewInfoId) {
        this.interviewInfoId = interviewInfoId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfessionalSkills() {
        return professionalSkills;
    }

    public void setProfessionalSkills(String professionalSkills) {
        this.professionalSkills = professionalSkills;
    }

    public Integer getHasCertificate() {
        return hasCertificate;
    }

    public void setHasCertificate(Integer hasCertificate) {
        this.hasCertificate = hasCertificate;
    }

    public Integer getIsDisability() {
        return isDisability;
    }

    public void setIsDisability(Integer isDisability) {
        this.isDisability = isDisability;
    }

    public String getRecommendEnterprise() {
        return recommendEnterprise;
    }

    public void setRecommendEnterprise(String recommendEnterprise) {
        this.recommendEnterprise = recommendEnterprise;
    }

    public String getRecommendJob() {
        return recommendJob;
    }

    public void setRecommendJob(String recommendJob) {
        this.recommendJob = recommendJob;
    }

    public String getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(String interviewTime) {
        this.interviewTime = interviewTime;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getSignUpId() {
        return signUpId;
    }

    public void setSignUpId(Integer signUpId) {
        this.signUpId = signUpId;
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

    @Override
    public String toString() {
        return "RoInterviewListAll{" +
                "interviewInfoId=" + interviewInfoId +
                ", customerName='" + customerName + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", education='" + education + '\'' +
                ", address='" + address + '\'' +
                ", professionalSkills='" + professionalSkills + '\'' +
                ", hasCertificate=" + hasCertificate +
                ", isDisability=" + isDisability +
                ", recommendEnterprise='" + recommendEnterprise + '\'' +
                ", recommendJob='" + recommendJob + '\'' +
                ", interviewTime='" + interviewTime + '\'' +
                ", deptName='" + deptName + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", customerId=" + customerId +
                ", signUpId=" + signUpId +
                ", phoneCallListId=" + phoneCallListId +
                ", employeeId=" + employeeId +
                '}';
    }
}
