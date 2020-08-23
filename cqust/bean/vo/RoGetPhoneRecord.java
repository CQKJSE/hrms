package cn.edu.cqust.bean.vo;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-16 16:57
 * @desc: /getPhoneRecord
 **/
@SuppressWarnings("unused")
public class RoGetPhoneRecord {
    private Integer phoneRecordId;
    private String name;
    private String idNumber;
    private String phoneNumber;
    private String recommendEnterprise;
    private String recommendJob;
    private String status;
    private String duration;
    private String ringduration;
    private String filepath;

    public Integer getPhoneRecordId() {
        return phoneRecordId;
    }

    public void setPhoneRecordId(Integer phoneRecordId) {
        this.phoneRecordId = phoneRecordId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRingduration() {
        return ringduration;
    }

    public void setRingduration(String ringduration) {
        this.ringduration = ringduration;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}
