package cn.edu.cqust.bean.vo;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-05 21:31
 * @desc: /callList
 **/
@SuppressWarnings("unused")
public class RoCallList {
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
    private String sourceOfData;
    private String note;
    private String phoneCallListId;
    private Integer isWechatAdded;
    private String recommendEnterprise;
    private String recommendJob;
    private Integer customerId;
    private Integer employeeId;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
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

    public String getSourceOfData() {
        return sourceOfData;
    }

    public void setSourceOfData(String sourceOfData) {
        this.sourceOfData = sourceOfData;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPhoneCallListId() {
        return phoneCallListId;
    }

    public void setPhoneCallListId(String phoneCallListId) {
        this.phoneCallListId = phoneCallListId;
    }

    public Integer getIsWechatAdded() {
        return isWechatAdded;
    }

    public void setIsWechatAdded(Integer isWechatAdded) {
        this.isWechatAdded = isWechatAdded;
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
}
