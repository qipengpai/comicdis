package com.crxl.qpp.comicdis.basics.service.impl;

import com.crxl.qpp.comicdis.basics.dao.*;
import com.crxl.qpp.comicdis.basics.entity.Cartoon;
import com.crxl.qpp.comicdis.basics.entity.Distributor;
import com.crxl.qpp.comicdis.basics.entity.DistributorTotalYmd;
import com.crxl.qpp.comicdis.basics.entity.data.Withdrawals;
import com.crxl.qpp.comicdis.exception.BusinessException;
import com.crxl.qpp.comicdis.tool.ArithUtil;
import com.crxl.qpp.comicdis.tool.DateUtil;
import com.crxl.qpp.comicdis.tool.ParaClick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class UserOrderServiceImpl {

    @Autowired
    private UserOrderMapper userOrderMapper;

    @Autowired
    private DistributorMapper distributorMapper;

    @Autowired
    private DistributorTotalYmdMapper distributorTotalYmdMapper;

    @Autowired
    private DistributorOrderMapper distributorOrderMapper;

    @Autowired
    private DistributorWithdrawalsMapper distributorWithdrawalsMapper;


    /**
     * 当日流水统计
     *
     * @param [authorization]
     * @return java.util.List<com.crxl.qpp.comicdis.basics.entity.data.Withdrawals>
     * @author pengpai
     * @date 2018/3/6 18:03
     */
    public Withdrawals getUserOrderWithdrawals(String qd, String orderDescription) {
        return userOrderMapper.getUserOrderWithdrawals(qd, orderDescription);
    }

    /**
     *    每日定时更新各渠道商本月和总数据
     *
     * @author pengpai
     * @date 2018/3/13 11:37
     * @param []
     * @return boolean
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean distributorTotalYmd() {
        // 累计统计最近一个月和总充值
        boolean flag = false;
        try {
            List<Distributor> list = distributorMapper.selectAllIdQd();
            if(!ParaClick.clickList(list))
                return flag;
            for (Distributor distributor : list) {
                Withdrawals numSum = userOrderMapper.distributorTotalYmd(distributor.getQd(), "101");
                Withdrawals numSum2 = userOrderMapper.distributorTotalYmd(distributor.getQd(), "102");
                Withdrawals sum = userOrderMapper.distributorTotalAll(distributor.getQd(), "101");
                Withdrawals sum2 = userOrderMapper.distributorTotalAll(distributor.getQd(), "102");
                Withdrawals now = userOrderMapper.distributorTotalToday(distributor.getQd(), "101");
                Withdrawals now2 = userOrderMapper.distributorTotalToday(distributor.getQd(), "102");
                List<DistributorTotalYmd> distributorTotalYmd = distributorTotalYmdMapper.selectByDistributorId(distributor.getId());
                String date= DateUtil.getdate_yyyy_MM_dd_HH_MM_SS();
                double total=ArithUtil.add(numSum.getTotal(),numSum2.getTotal());
                double total1=ArithUtil.add(sum.getTotal(),sum2.getTotal());
                double total2=ArithUtil.add(now.getTotal(),now2.getTotal());
                if (!ParaClick.clickList(distributorTotalYmd)) {

                    int flag2 = distributorTotalYmdMapper
                            .addDistributorTotal(ArithUtil.sub(numSum.getTotal(),now.getTotal()),
                                    numSum.getNumCount()-now.getNumCount(),
                                    distributor.getId(), 1, ArithUtil.sub(numSum2.getTotal(),now2.getTotal()),
                                    numSum2.getNumCount()-now2.getNumCount(),date,
                                    ArithUtil.sub(total,total2),0.0,0);
                    int flag3 = distributorTotalYmdMapper
                            .addDistributorTotal(ArithUtil.sub(sum.getTotal(),now.getTotal()),
                                    sum2.getNumCount()-now.getNumCount(),
                                    distributor.getId(), 2, ArithUtil.sub(sum2.getTotal(),now2.getTotal()),
                                    sum2.getNumCount()-now2.getNumCount()
                                    ,date,ArithUtil.sub(total1,total2),0.0,0);
                    if (flag2 < 1||flag3<1)
                        throw new BusinessException("异常");
                } else {
                    int flag4 = distributorTotalYmdMapper
                            .updateDistributorTotal(ArithUtil.sub(numSum.getTotal(),now.getTotal()),
                                    numSum.getNumCount()-now.getNumCount(),
                                    distributorTotalYmd.get(0).getId(), 1,ArithUtil.sub(numSum2.getTotal(),now2.getTotal()),
                                    numSum2.getNumCount()-now2.getNumCount(),
                                   date,ArithUtil.sub(total,total2),
                                    0.0,0,distributor.getId());
                    int flag5 = distributorTotalYmdMapper
                            .updateDistributorTotal(ArithUtil.sub(sum.getTotal(),now.getTotal()),
                                    sum.getNumCount()-now.getNumCount(),
                                    distributorTotalYmd.get(1).getId(), 2, ArithUtil.sub(sum2.getTotal(),now2.getTotal()),
                                    sum2.getNumCount()-now2.getNumCount()
                                    ,date,ArithUtil.sub(total1,total2),
                                    0.0,0,distributor.getId());
                    if (flag4 < 1||flag5<1)
                        throw new BusinessException("异常");
                }
            }
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            return flag;
        }
        return flag;
    }
    /**
     *    每日定时生成各渠道商各项数据统计
     *
     * @author pengpai
     * @date 2018/3/13 11:36
     * @param []
     * @return boolean
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public boolean distributorOrderTotal() {
        // 定时统计每天各个渠道商的各项数据
        boolean flag = false;
        try {
            List<Distributor> list = distributorMapper.selectAllIdQd();
            if(!ParaClick.clickList(list))
                return flag;
            for (Distributor distributor : list) {
                Withdrawals numSum = userOrderMapper.distributorOrderTotal(distributor.getQd(), "101");
                Withdrawals numSum2 = userOrderMapper.distributorOrderTotal(distributor.getQd(), "102");
                String date= DateUtil.getYesterday();
                Double add=ArithUtil.add(numSum.getTotal(),numSum2.getTotal());
                Double a=0.0;
                if(add>0)
                    a=add/(numSum.getUserCount()+numSum2.getUserCount());
                int flag2 = distributorOrderMapper
                            .addDistributorOrderTotal(distributor.getId(),date,1,add,
                                    numSum.getTotal(),numSum.getNumCount(),0,0.0,
                                    numSum2.getTotal(),0, numSum2.getNumCount(),0.0,
                                    numSum.getUserCount()+numSum2.getUserCount(),a);
                if (flag2 < 1)
                        throw new BusinessException("异常");
            }
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            return flag;
        }
        return flag;
    }

    /**
     *    每日定时生成结算单
     *
     * @author pengpai
     * @date 2018/3/13 11:36
     * @param []
     * @return boolean
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public boolean
    distributorWithdrawals() {
        // 生成待结算单
        boolean flag=true;
        String yesterday = DateUtil.getYesterday()+" 12:23:34";
        DecimalFormat df = new DecimalFormat("#.00");
        try {
            List<Distributor> list = distributorMapper.selectAllIdQd2();
            if(!ParaClick.clickList(list))
                return flag;
            for (Distributor distributor : list) {
                Withdrawals numSum = userOrderMapper.selectDistributorWithdrawals(distributor.getQd());
                String date= DateUtil.getdate_yyyy_MM_dd_HH_MM_SS();
                Double sum=0.0;
                if (Double.parseDouble(numSum.getTotal().toString())>0) {
                    sum = Double.parseDouble(df.format((Double
                            .parseDouble(numSum.getTotal().toString()) - (Double
                            .parseDouble(numSum.getTotal().toString()) * 0.01))
                            * distributor.getProportion()));
                }
                //增加分销商结算单增加分销商结算单
                int flag2=distributorWithdrawalsMapper.addDistributorWithdrawals(numSum.getTotal(),sum,
                        numSum.getNumCount(),distributor.getId(),distributor.getProportion(),
                        distributor.getNickname(),date,0,yesterday);
                if (flag2<0)
                    throw new BusinessException("异常");
                //定时器统计后增家分销商总收益和未领取收益
                double a=ArithUtil.add(sum,distributor.getAllrecharge());
                double b=ArithUtil.add(sum,distributor.getBalance());
                int flag3=distributorMapper.updateReCharge(a,distributor.getId(),b);
                if (flag3<0)
                    throw new BusinessException("异常");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return flag;
        }
        return flag;
    }
}
