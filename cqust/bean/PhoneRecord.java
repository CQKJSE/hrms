package cn.edu.cqust.bean;

/**
 * @project: HRMS
 * @author: Tang.F.C
 * @date: 2020-08-05 10:52
 * @desc:
 */
@SuppressWarnings("unused")
public class PhoneRecord {
    private Integer id;
    private String status;
    private String duration;
    private String ringduration;
    private String filepath;
    private Integer customerId;
    private Integer phoneCallListId;
    private Integer employeeId;
    private String createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
