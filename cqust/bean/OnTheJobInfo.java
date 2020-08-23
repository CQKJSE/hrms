package cn.edu.cqust.bean;

/**
 * @project: HRMS
 * @author: Tang.F.C
 * @date: 2020-08-011 15:52
 * @desc:
 */
@SuppressWarnings("unused")
public class OnTheJobInfo {
    private Integer id;
    private String contractExpireTime;
    private String emergencyContact;
    private String emergencyContactPhone;
    private String insurance;
    private String unit;
    private String inductionTime;
    private String state;
    private String departureTime;
    private Integer customerId;
    private Integer phoneCallListId;
    private Integer employeeId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getContractExpireTime() {
        return contractExpireTime;
    }

    public void setContractExpireTime(String contractExpireTime) {
        this.contractExpireTime = contractExpireTime;
    }


    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }


    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }


    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }


    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

}
