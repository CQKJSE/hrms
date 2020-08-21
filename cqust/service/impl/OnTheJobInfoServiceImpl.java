package cn.edu.cqust.service.impl;

import cn.edu.cqust.bean.CustomerInfo;
import cn.edu.cqust.bean.OnTheJobInfo;
import cn.edu.cqust.bean.SettlementInfo;
import cn.edu.cqust.bean.WaitInductionInfo;
import cn.edu.cqust.bean.vo.QoOnTheJobAll;
import cn.edu.cqust.bean.vo.RoOnTheJob;
import cn.edu.cqust.bean.vo.RoOnTheJobAll;
import cn.edu.cqust.dao.OnTheJobInfoDao;
import cn.edu.cqust.dao.SettlementInfoDao;
import cn.edu.cqust.dao.TableInfoDao;
import cn.edu.cqust.dao.WaitInductionInfoDao;
import cn.edu.cqust.service.OnTheJobInfoService;
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
}
