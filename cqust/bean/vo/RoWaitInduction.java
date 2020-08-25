package cn.edu.cqust.bean.vo;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-12 09:33
 * @desc:
 **/
@SuppressWarnings("unused")
public class RoWaitInduction {
    //wait_induction_info.id
    private Integer waitInductionId;
    //customer_info
    private String name;
    private String idNumber;
    private String gender;
    private Integer age;
    private String phoneNumber;
    private String education;
    private String address;
    private String professionalSkills;
    private Integer hasCertificate;
    private Integer isDisability;
    //phone_call_list
    private String recommendEnterprise;
    private String recommendJob;
    //wait_induction_info
    private String interviewQualifiedTime;
    private String state;
    private String delayTime;
    private String note;
    private Integer employeeId;
    private Integer customerId;
    private Integer phoneCallListId;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
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

    public Integer getWaitInductionId() {
        return waitInductionId;
    }

    public void setWaitInductionId(Integer waitInductionId) {
        this.waitInductionId = waitInductionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "RoWaitInduction{" +
                "waitInductionId=" + waitInductionId +
                ", name='" + name + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", education='" + education + '\'' +
                ", address='" + address + '\'' +
                ", professionalSkills='" + professionalSkills + '\'' +
                ", hasCertificate=" + hasCertificate +
                ", isDisability=" + isDisability +
                ", employeeId=" + employeeId +
                ", customerId=" + customerId +
                ", phoneCallListId=" + phoneCallListId +
                ", recommendEnterprise='" + recommendEnterprise + '\'' +
                ", recommendJob='" + recommendJob + '\'' +
                ", interviewQualifiedTime='" + interviewQualifiedTime + '\'' +
                ", state='" + state + '\'' +
                ", delayTime='" + delayTime + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
