package com.boot.security.server.controller;

import com.alibaba.fastjson.JSON;
import com.boot.security.server.model.AiMktBox;
import com.boot.security.server.model.AiOperator;
import com.boot.security.server.model.SysUser;
import com.boot.security.server.result.FanReport;
import com.boot.security.server.service.impl.AiMktBoxServiceImpl;
import com.boot.security.server.service.impl.AiOperatorServiceImpl;
import com.boot.security.server.service.impl.ReportFormServiceImpl;
import com.boot.security.server.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/reportForm")
public class ReportFormController {

    @Autowired
    private ReportFormServiceImpl reportFormService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private AiOperatorServiceImpl aiOperatorService;

    @Autowired
    private AiMktBoxServiceImpl aiMktBoxService;

    /**
     *
     * 功能描述: 根据运营商id查询报表所需数据
     * 1. 根据userId查询运营商(不是运营商直接显示所有订单的报表)
     * 2. 根据operatorID(运营商id)查询出所属的所有的boxId(结果为List)
     * 3. 根据List中的值以及相年份匹配报表信息
     *
     * @auther: Soledad
     * @date: 2018/10/8 0008 11:10
     */

    @GetMapping("/getPayType")
    @ApiOperation(value = "获取支付类型数据")
    public FanReport getpayType(HttpServletRequest request){
        SysUser user = userService.getTokenUser(request);
        AiOperator aiOperator = aiOperatorService.getAiOperatorByUserId(user.getId());
        //如果没有绑定运营商(即高级管理员)返回所有数据
        if(aiOperator==null){
            return reportFormService.getFanReport();
        }else {
            //查询所属box
            List<AiMktBox> boxList = aiMktBoxService.getBoxListByOperatorId(aiOperator.getId());
            //根据boxId查询所属的订单
            return reportFormService.getFanReportWithBoxCode(boxList);
        }

    }

    @GetMapping("/getTurnover")
    @ApiOperation(value = "获取每月营收总额")
    public List<BigDecimal> getTurnover(HttpServletRequest request){
        SysUser user = userService.getTokenUser(request);
        AiOperator aiOperator = aiOperatorService.getAiOperatorByUserId(user.getId());
        if(aiOperator==null){
            return reportFormService.getTurnover(new Date());
        }else{
            //查询所属box
            List<AiMktBox> boxList = aiMktBoxService.getBoxListByOperatorId(aiOperator.getId());
            //根据boxId查询所属的订单
            List<Long> boxCodeList = new ArrayList<>();
            for (AiMktBox b :boxList
            ) {
                boxCodeList.add(b.getId());
            }
            return reportFormService.getTurnoverWithBoxCode(new Date(),boxCodeList);
        }

    }

}
