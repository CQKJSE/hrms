package cn.edu.cqust.bean;

/**
 * @project: HRMS
 * @author: Tang.F.C
 * @date: 2020-08-05 10:52
 * @desc:
 */
@SuppressWarnings("unused")
public class EnterpriseDemandInfo {
    private Integer id;
    private String job;
    private String number;
    private String wage;
    private Integer enterpriseId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage;
    }


    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

}
