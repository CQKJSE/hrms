package cn.edu.cqust.bean;

/**
 * @project: HRMS
 * @author: Tang.F.C
 * @date: 2020-08-011 15:52
 * @desc:
 */
@SuppressWarnings("unused")
public class SettlementInfo {
    private Integer id;
    private String settlementNumber;
    private String settlementStandard;
    private String attendanceDays;
    private String attendanceHours;
    private String standard;
    private String price;
    private String mark;
    private String note;
    private String state;
    private String cycle;
    private String settlementTime;
    private String credentials;
    private Integer customerId;
    private Integer phoneCallListId;
    private Integer onTheJobId;
    private Integer employeeId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getSettlementNumber() {
        return settlementNumber;
    }

    public void setSettlementNumber(String settlementNumber) {
        this.settlementNumber = settlementNumber;
    }


    public String getSettlementStandard() {
        return settlementStandard;
    }

    public void setSettlementStandard(String settlementStandard) {
        this.settlementStandard = settlementStandard;
    }


    public String getAttendanceDays() {
        return attendanceDays;
    }

    public void setAttendanceDays(String attendanceDays) {
        this.attendanceDays = attendanceDays;
    }


    public String getAttendanceHours() {
        return attendanceHours;
    }

    public void setAttendanceHours(String attendanceHours) {
        this.attendanceHours = attendanceHours;
    }


    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }


    public String getSettlementTime() {
        return settlementTime;
    }

    public void setSettlementTime(String settlementTime) {
        this.settlementTime = settlementTime;
    }


    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
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


    public Integer getOnTheJobId() {
        return onTheJobId;
    }

    public void setOnTheJobId(Integer onTheJobId) {
        this.onTheJobId = onTheJobId;
    }


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

}
