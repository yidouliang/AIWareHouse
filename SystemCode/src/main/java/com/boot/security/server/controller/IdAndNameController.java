package com.boot.security.server.controller;

import com.boot.security.server.dao.AiExecProductDao;
import com.boot.security.server.dto.IdAndNameDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created By Seven.wk
 * Description: 获取实体类中的id和name键值对
 * Created At 2018/09/28
 */
@RestController
@RequestMapping("/idAndName")
public class IdAndNameController {

    @Autowired
    private AiExecProductDao aiExecProductDao;

    @GetMapping("/aiExecProduct")
    @ApiOperation(value = "获得product的id与Name的键值对")
    public List<IdAndNameDto> getIdAndName() {
        List<Map<String, Object>> mapList = aiExecProductDao.getIdAndName();
        return getIdAndName(mapList);
    }

    private List<IdAndNameDto> getIdAndName(List<Map<String, Object>> mapList) {
        List<IdAndNameDto> idAndNameDtoList = new ArrayList<>();
        for(Map<String, Object> kv : mapList) {
            IdAndNameDto idAndNameDto = new IdAndNameDto();
            int i = 0;
            Object[] arr = new Object[2];
            for (Object o : kv.keySet()) {
                arr[i++] = kv.get(o);
            }

            idAndNameDto.setId(arr[1]);
            idAndNameDto.setName(arr[0]);
            idAndNameDtoList.add(idAndNameDto);
        }
        return idAndNameDtoList;
    }
}
