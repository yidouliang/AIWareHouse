package com.boot.security.server.controller;

import com.boot.security.server.service.impl.ReportFormServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reportForm")
public class ReportFormController {

    @Autowired
    private ReportFormServiceImpl reportFormService;

    @GetMapping("/getPayType")
    @ApiOperation(value = "获取支付类型数据")
    public List<String> getpayType(){

        return reportFormService.getPayType();
    }

//    @GetMapping("/getTypeCount")
//    @ApiOperation(value = "获取支付类型对应的参数")
//    public List<Integer> getpayTypeCount(){
//        return reportFormService.getpayTypeCount();
//    }
}
