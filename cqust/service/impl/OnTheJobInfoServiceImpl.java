package cn.edu.cqust.service.impl;

import cn.edu.cqust.bean.*;
import cn.edu.cqust.bean.vo.QoOnTheJobAll;
import cn.edu.cqust.bean.vo.QoUpdateOnTheJob;
import cn.edu.cqust.bean.vo.RoOnTheJob;
import cn.edu.cqust.bean.vo.RoOnTheJobAll;
import cn.edu.cqust.dao.*;
import cn.edu.cqust.service.OnTheJobInfoService;
import cn.edu.cqust.util.BeanHelper;
import cn.edu.cqust.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project: HRMS_SpringbootDemo
 * @author: F.C.Tang
 * @date: 2020-08-20 11:42
 * @desc:
 **/
@Service
public class OnTheJobInfoServiceImpl implements OnTheJobInfoService {

    @Resource
    private OnTheJobInfoDao onTheJobInfoDao;
    @Resource
    private WaitInductionInfoDao waitInductionInfoDao;
    @Resource
    private SettlementInfoDao settlementInfoDao;
    @Resource
    private CustomerInfoDao customerInfoDao;
    @Resource
    private PhoneCallListDao phoneCallListDao;

    @Override
    public List<RoOnTheJob> findByMC1(CustomerInfo customerInfo, String employeePhone, Integer page) {
        return onTheJobInfoDao.findByMC1(
                customerInfo,
                employeePhone,
                (page - 1) * 10
        );
    }

    @Override
    public Integer countByMC1(CustomerInfo customerInfo, String employeePhone) {
        return onTheJobInfoDao.findByMC1(
                customerInfo,
                employeePhone,
                null
        ).size();
    }

    @Override
    public List<RoOnTheJobAll> findByMC2(QoOnTheJobAll qo, Integer page) {
        return onTheJobInfoDao.findByMC2(qo, (page - 1) * 10);
    }

    @Override
    public Integer countByMC2(QoOnTheJobAll qo) {
        return onTheJobInfoDao.findByMC2(qo, null).size();
    }

    @Override
    public Integer addOnTheJob(OnTheJobInfo onTheJobInfo) {
        WaitInductionInfo wii1 = new WaitInductionInfo();
        wii1.setCustomerId(onTheJobInfo.getCustomerId());
        wii1.setPhoneCallListId(onTheJobInfo.getPhoneCallListId());
        wii1.setEmployeeId(onTheJobInfo.getEmployeeId());
        List<WaitInductionInfo> wiiList = waitInductionInfoDao.find(wii1);
        if (wiiList.size() != 1)
            return -1;
        //待修改的WaitInductionInfo
        WaitInductionInfo wii2 = wiiList.get(0);
        wii2.setStateOne(1);
        wii2.setNote("通过");
        System.out.println("mark");
        System.out.println(wii2);

        if (waitInductionInfoDao.update(wii2) != 1)
            return -1;

        //待添加的OnTheJobInfo
        onTheJobInfo.setState("在职");
        onTheJobInfo.setInductionTime(DateUtil.getYMD());

        if (onTheJobInfoDao.insert(onTheJobInfo) != 1)
            return -1;

        //待添加的SettlementInfo
        SettlementInfo si = new SettlementInfo();
        si.setOnTheJobId(onTheJobInfoDao.findMaxId());
        si.setCustomerId(onTheJobInfo.getCustomerId());
        si.setPhoneCallListId(onTheJobInfo.getPhoneCallListId());
        si.setEmployeeId(onTheJobInfo.getEmployeeId());
        si.setState("待结算");
        return settlementInfoDao.insert(si) == 1 ? 1 : -1;
        /*return waitInductionInfoDao.update(wii2) == 1 ?
                (onTheJobInfoDao.insert(onTheJobInfo) == 1 ?
                        (settlementInfoDao.insert(si) == 1 ? 1 : -1) : -1) : -1;*/
    }

    @Override
    public Integer updateAndRelated1(QoUpdateOnTheJob qo) {
        OnTheJobInfo otji = onTheJobInfoDao.findById(qo.getId());
        otji.setInductionTime(qo.getInductionTime());
        otji.setState(qo.getState());
        otji.setContractExpireTime(qo.getContractExpireTime());
        otji.setEmergencyContact(qo.getEmergencyContact());
        otji.setEmergencyContactPhone(qo.getEmergencyContactPhone());
        otji.setInsurance(qo.getInsurance());
        otji.setUnit(qo.getUnit());
        otji.setDepartureTime(qo.getDepartureTime());

        CustomerInfo ci = new CustomerInfo();
        ci.setId(otji.getCustomerId());
        ci.setName(qo.getName());
        ci.setIdNumber(qo.getIdNumber());
        ci.setGender(qo.getGender());
        ci.setAge(qo.getAge());
        ci.setPhoneNumber(qo.getPhoneNumber());

        PhoneCallList pcl = new PhoneCallList();
        pcl.setId(otji.getPhoneCallListId());
        pcl.setRecommendEnterprise(qo.getRecommendEnterprise());
        pcl.setRecommendJob(qo.getRecommendJob());

        int s1 = -1;
        int s2 = -1;
        int s3 = -1;
        if (!BeanHelper.isEmptyBean(ci, "id"))
            s1 = customerInfoDao.update(ci);
        if (!BeanHelper.isEmptyBean(pcl, "id"))
            s2 = phoneCallListDao.update(pcl);
        if (!BeanHelper.isEmptyBean(otji, "id"))
            s3 = onTheJobInfoDao.update(otji);
        return (s1 == 1 || s2 == 1 || s3 == 1) ? 1 : -1;
    }
}
