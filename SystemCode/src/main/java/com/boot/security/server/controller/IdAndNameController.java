package com.boot.security.server.controller;

import com.boot.security.server.dao.AiExecProductDao;
import com.boot.security.server.dao.AiMktBoxDao;
import com.boot.security.server.dao.AiOperatorDao;
import com.boot.security.server.dao.AiWarehouseDao;
import com.boot.security.server.dto.IdAndNameDto;
import com.boot.security.server.model.SysUser;
import com.boot.security.server.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private AiWarehouseDao aiWarehouseDao;

    @Autowired
    private AiMktBoxDao aiMktBoxDao;

    @Autowired
    private AiOperatorDao aiOperatorDao;

    @Autowired
    private UserService userService;

    @GetMapping("/aiExecProduct/{productTypeId}")
    @ApiOperation(value = "获得product的id与Name的键值对")
    public List<IdAndNameDto> getProductIdAndName(@PathVariable(value = "productTypeId") Long productTypeId) {
        List<Map<String, Object>> mapList = aiExecProductDao.getIdAndName(productTypeId);
        return getIdAndName(mapList);
    }

    @GetMapping("/aiWarehouse")
    @ApiOperation(value = "获得仓库的id和Name键值对")
    public List<IdAndNameDto> getWarehouseIdAndName(HttpServletRequest request) {
        SysUser user = userService.getTokenUser(request);
        Long operatorId = user.getOperatorid() == null ? 0 : user.getOperatorid();
        List<Map<String, Object>> mapList = aiWarehouseDao.getIdAndName(operatorId);
        return getIdAndName(mapList);
    }

    @GetMapping("/aiMktBox")
    @ApiOperation(value = "获得aiBox的id和name键值对")
    public List<IdAndNameDto> getMktBoxIdAndName(HttpServletRequest request) {
        SysUser user = userService.getTokenUser(request);
        Long operatorId = user.getOperatorid() == null ? 0 : user.getOperatorid();
        List<Map<String, Object>> mapList = aiMktBoxDao.getIdAndName(operatorId);
        return getIdAndName(mapList);
    }

    @GetMapping("/aiOperator")
    @ApiOperation(value = "获得aiOperator的id和name键值对")
    public List<IdAndNameDto> getAiOperatorIdAndName(){
        List<Map<String,Object>> mapList = aiOperatorDao.getIdAndName();
        return getIdAndName(mapList);
    }

    private List<IdAndNameDto> getIdAndName(List<Map<String, Object>> mapList) {
        List<IdAndNameDto> idAndNameDtoList = new ArrayList<>();
        for(Map<String, Object> kv : mapList) {
            IdAndNameDto idAndNameDto = new IdAndNameDto();
            for (Object o : kv.keySet()) {
                if(kv.get(o) instanceof Long)
                    idAndNameDto.setId(kv.get(o));
                else
                    idAndNameDto.setName(kv.get(o));
            }

            idAndNameDtoList.add(idAndNameDto);
        }
        return idAndNameDtoList;
    }

}
