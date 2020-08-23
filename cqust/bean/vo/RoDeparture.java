package cn.edu.cqust.bean.vo;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-22 17:34
 * @desc: /departure
 **/
@SuppressWarnings("unused")
public class RoDeparture {
    private Integer employeeDepartureId;

    private Integer idWork;
    private String name;
    private Integer idNumber;
    private String gender;
    private String inductionTime;
    private String deptName;
    private String position;

    private String leavingReason;
    private String tool;
    private String confirm;
    private String handover;
    private String note;
    private Integer employeeId;

    public Integer getEmployeeDepartureId() {
        return employeeDepartureId;
    }

    public void setEmployeeDepartureId(Integer employeeDepartureId) {
        this.employeeDepartureId = employeeDepartureId;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLeavingReason() {
        return leavingReason;
    }

    public void setLeavingReason(String leavingReason) {
        this.leavingReason = leavingReason;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getHandover() {
        return handover;
    }

    public void setHandover(String handover) {
        this.handover = handover;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
