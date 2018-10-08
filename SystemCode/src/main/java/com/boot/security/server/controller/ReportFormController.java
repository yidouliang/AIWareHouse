package com.boot.security.server.controller;

import com.boot.security.server.result.FanReport;
import com.boot.security.server.service.impl.ReportFormServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/reportForm")
public class ReportFormController {

    @Autowired
    private ReportFormServiceImpl reportFormService;

    @GetMapping("/getPayType")
    @ApiOperation(value = "获取支付类型数据")
    public FanReport getpayType(){
        return reportFormService.getFanReport();
    }

    @GetMapping("/getTurnover")
    @ApiOperation(value = "获取每月营收总额")
    public List<BigDecimal> getTurnover(){
        return reportFormService.getTurnover(new Date());
    }

}
