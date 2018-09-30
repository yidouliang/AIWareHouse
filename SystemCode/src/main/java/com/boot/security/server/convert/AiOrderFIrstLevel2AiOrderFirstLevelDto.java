package com.boot.security.server.convert;

import com.boot.security.server.dao.DictDao;
import com.boot.security.server.dto.AiOrderFirstLevelDto;
import com.boot.security.server.model.AiOrderFirstLevel;
import com.boot.security.server.model.Dict;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class AiOrderFIrstLevel2AiOrderFirstLevelDto {

    public static void aiOrderFIrstLevelAiOrderFirstLevelDto(DictDao dictDao,List<AiOrderFirstLevel> aiOrderFirstLevels, List<AiOrderFirstLevelDto> aiOrderFirstLevelDtos){

        List<Dict> aiOrderpaystatus = dictDao.listByType("aiOrderPayStatus");
        List<Dict> aiOrderPaytype = dictDao.listByType("aiOrderPayType");
        List<Dict> dataStates= dictDao.listByType("dataState");

        for (AiOrderFirstLevel a :
                aiOrderFirstLevels) {
            AiOrderFirstLevelDto aiOrderFirstLevelDto = new AiOrderFirstLevelDto();
            BeanUtils.copyProperties(a,aiOrderFirstLevelDto);
            aiOrderFirstLevelDto.setPaystatus(String.valueOf(a.getPaystatus()));
            aiOrderFirstLevelDto.setPaytype(String.valueOf(a.getPaytype()));
            aiOrderFirstLevelDto.setDatastate(String.valueOf(a.getDatastate()));
            for (Dict d: aiOrderpaystatus
                 ) {
                if(aiOrderFirstLevelDto.getPaystatus().equals(d.getK())){
                    aiOrderFirstLevelDto.setPaystatus(d.getVal());
                }
            }
            for (Dict d: aiOrderPaytype
            ) {
                if(aiOrderFirstLevelDto.getPaytype().equals(d.getK())){
                    aiOrderFirstLevelDto.setPaytype(d.getVal());
                }
            }
            for (Dict d: dataStates
            ) {
                if(aiOrderFirstLevelDto.getDatastate().equals(d.getK())){
                    aiOrderFirstLevelDto.setDatastate(d.getVal());
                }
            }
            aiOrderFirstLevelDtos.add(aiOrderFirstLevelDto);
        }

    }
}
