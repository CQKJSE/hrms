package cn.edu.cqust.bean.vo;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-20 10:59
 * @desc: /onTheJob
 **/
@SuppressWarnings("unused")
public class RoOnTheJob {
    private Integer id;
    private String name;
    private String idNumber;
    private String gender;
    private Integer age;
    private String phoneNumber;
    private String recommendEnterprise;
    private String recommendJob;
    private String inductionTime;
    private String state;
    private String departureTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getInductionTime() {
        return inductionTime;
    }

    public void setInductionTime(String inductionTime) {
        this.inductionTime = inductionTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}
