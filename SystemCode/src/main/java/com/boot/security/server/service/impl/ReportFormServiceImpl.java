package com.boot.security.server.service.impl;

import com.boot.security.server.dao.AiOrderFirstLevelDao;
import com.boot.security.server.dao.DictDao;
import com.boot.security.server.model.AiMktBox;
import com.boot.security.server.model.Dict;
import com.boot.security.server.result.FanReport;
import com.boot.security.server.result.MonthSum;
import com.boot.security.server.result.PayCount;
import com.boot.security.server.result.PayTypeAndValue;
import com.boot.security.server.service.ReportFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ReportFormServiceImpl implements ReportFormService {

    @Autowired
    private DictDao dictDao;

    @Autowired
    private AiOrderFirstLevelDao firstLevelDao;



    @Override
    public FanReport getFanReport() {
        //先获取支付类型
        List<PayTypeAndValue> payTypeAndVals = getPayTypenum();
        //将type的字符串数据存入payTypes中
        List<String> payTypes = new ArrayList<>();
        //用于存放报表的key-value
        List<PayCount> payCounts = new ArrayList<>();
        //通过支付类型查询订单表所有支付类型为某类型的数量
        //封装数据
        for(PayTypeAndValue p : payTypeAndVals){
            PayCount payCount = new PayCount();
            payCount.setValue(firstLevelDao.getPayTypeCount(p.getPayType()));
            payCount.setName(p.getPayName());
            payCounts.add(payCount);
            payTypes.add(p.getPayName());
        }
        FanReport fanReport = new FanReport();
        fanReport.setPayTypes(payTypes);
        fanReport.setPayCounts(payCounts);
        return fanReport;
    }

    @Override
    public FanReport getFanReportWithBoxCode(List<AiMktBox> boxList) {
        //先获取支付类型
        List<PayTypeAndValue> payTypeAndVals = getPayTypenum();
        //将type的字符串数据存入payTypes中
        List<String> payTypes = new ArrayList<>();
        //用于存放报表的key-value
        List<PayCount> payCounts = new ArrayList<>();

        //根据boxCode查询
        for(PayTypeAndValue p : payTypeAndVals){
            payTypes.add(p.getPayName());
            PayCount payCount = new PayCount();
            payCount.setName(p.getPayName());
            for (AiMktBox box:boxList
                ) {
                payCount.setValue(payCount.getValue() + firstLevelDao.getPayTypeCountWithBoxCode(p.getPayType(),box.getBoxcode()));
            }
            payCounts.add(payCount);
        }
        FanReport fanReport = new FanReport();
        fanReport.setPayTypes(payTypes);
        fanReport.setPayCounts(payCounts);
        return fanReport;
    }



    @Override
    public List<BigDecimal> getTurnover(Date nowDay) {
        Calendar calendar = Calendar.getInstance();//日历对象
        calendar.setTime(nowDay);//设置当前日期

        //当前日期的整型
        Integer nowYear = calendar.get(Calendar.YEAR);

        Integer beginDay = (nowYear-1)*100+12;
        Integer endDay = (nowYear+1)*100+1;

        List<BigDecimal> sumList = new ArrayList<>();
        //获取月份营业额
        List<MonthSum> monthSums = new ArrayList<>();
        monthSums = firstLevelDao.getMounthTurnover(beginDay,endDay);
        //校验数据是否存在
        for(int i = 1;i < 13;i++){
            boolean isExist = false;
            for (MonthSum m :monthSums
                    ) {
                //当月份存在的时候
                if(m.getMonths()== nowYear*100+i){
                    sumList.add(m.getSumPrice());
                    isExist = true;
                }
            }
            if(!isExist){
                sumList.add(new BigDecimal(String.valueOf(0)));
            }
        }
        return sumList;
    }

    @Override
    public List<BigDecimal> getTurnoverWithBoxCode(Date nowDay, List<String> boxCodeList) {
        Calendar calendar = Calendar.getInstance();//日历对象
        calendar.setTime(nowDay);//设置当前日期

        //当前日期的整型
        Integer nowYear = calendar.get(Calendar.YEAR);

        Integer beginDay = (nowYear-1)*100+12;
        Integer endDay = (nowYear+1)*100+1;

        List<BigDecimal> sumList = new ArrayList<>();
        //获取月份营业额
        List<MonthSum> monthSums = new ArrayList<>();
        monthSums = firstLevelDao.getMounthTurnoverWithBoxCode(beginDay,endDay,boxCodeList);
        //校验数据是否存在
        for(int i = 1;i < 13;i++){
            boolean isExist = false;
            for (MonthSum m :monthSums
            ) {
                //当月份存在的时候
                if(m.getMonths()== nowYear*100+i){
                    sumList.add(m.getSumPrice());
                    isExist = true;
                }
            }
            if(!isExist){
                sumList.add(new BigDecimal(String.valueOf(0)));
            }
        }
        return sumList;
    }


    //获取支付类型与中文名称(typeAndValue)
    private List<PayTypeAndValue> getPayTypenum() {
        //获取字典中的支付类型
        List<Dict> payDicts = dictDao.listByType("aiOrderPayType");
        List<PayTypeAndValue> payTypes = new ArrayList<>();
        for (Dict d: payDicts
        ) {
            PayTypeAndValue typeAndValue = new PayTypeAndValue();
            typeAndValue.setPayType(Integer.valueOf(d.getK()));
            typeAndValue.setPayName(d.getVal());
            payTypes.add(typeAndValue);
        }
        return payTypes;
    }

}
