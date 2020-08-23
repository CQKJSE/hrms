package cn.edu.cqust.bean;

/**
 * @project: HRMS
 * @author: Tang.F.C
 * @date: 2020-08-22 17:20
 * @desc:
 */
@SuppressWarnings("unused")
public class EmployeesDeparture {
    private Integer id;
    private String leavingReason;
    private String tool;
    private String confirm;
    private String handover;
    private String note;
    private Integer employeeId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
