package cn.edu.cqust.bean;

/**
 * @project: HRMS
 * @author: Tang.F.C
 * @date: 2020-08-05 10:52
 * @desc:
 */
@SuppressWarnings("unused")
public class EnterpriseInfo {

    private Integer id;
    private String enterpriseName;
    private String address;
    private String welfare;
    private String roomAndBoard;
    private String head;
    private String phone;
    private String place;
    private String time;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }


    public String getRoomAndBoard() {
        return roomAndBoard;
    }

    public void setRoomAndBoard(String roomAndBoard) {
        this.roomAndBoard = roomAndBoard;
    }


    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "EnterpriseInfo{" +
                "id=" + id +
                ", enterpriseName='" + enterpriseName + '\'' +
                ", address='" + address + '\'' +
                ", welfare='" + welfare + '\'' +
                ", roomAndBoard='" + roomAndBoard + '\'' +
                ", head='" + head + '\'' +
                ", phone='" + phone + '\'' +
                ", place='" + place + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
