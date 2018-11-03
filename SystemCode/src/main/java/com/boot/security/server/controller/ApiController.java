package com.boot.security.server.controller;

import com.boot.security.server.dto.ResponseInfo;
import com.boot.security.server.enums.SystemStatusEnum;
import com.boot.security.server.model.AiConsumer;
import com.boot.security.server.service.AiConsumerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created By Seven.wk
 * Description: 系统向外提供的api接口
 * Created At 2018/11/03
 */
@RestController
@RequestMapping(value = "/api")
@CrossOrigin
public class ApiController {

    @Autowired
    private AiConsumerService aiConsumerService;

    @GetMapping("/consumer/{consumerId}")
    @ApiOperation(value = "根据consumerId查询用户信息")
    public ResponseInfo getConsumerInfo(@PathVariable String consumerId) {
        AiConsumer aiConsumer = aiConsumerService.getInfoByConsumerId(consumerId);
        return new ResponseInfo<>(SystemStatusEnum.SUCCESS, aiConsumer);
    }
}
