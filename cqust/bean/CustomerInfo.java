package cn.edu.cqust.bean;

/**
 * @project: HRMS
 * @author: Tang.F.C
 * @date: 2020-08-05 10:52
 * @desc:
 */
@SuppressWarnings("unused")
public class CustomerInfo {
    private Integer id;
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
    private String state;
    private String addedTime;
    private String addedPerson;

    public CustomerInfo() {
    }

    public CustomerInfo(Integer id, String state) {
        this.id = id;
        this.state = state;
    }

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


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(String addedTime) {
        this.addedTime = addedTime;
    }

    public String getAddedPerson() {
        return addedPerson;
    }

    public void setAddedPerson(String addedPerson) {
        this.addedPerson = addedPerson;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" +
                "id=" + id +
                ", name='" + name +
                ", idNumber='" + idNumber +
                ", address='" + address +
                ", note='" + note +
                ", state='" + state +
                '}';
    }
}
