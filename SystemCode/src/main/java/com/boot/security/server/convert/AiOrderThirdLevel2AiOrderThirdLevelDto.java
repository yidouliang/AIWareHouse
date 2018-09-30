package com.boot.security.server.convert;

import com.boot.security.server.dao.DictDao;
import com.boot.security.server.dto.AiOrderThirdLevelDto;
import com.boot.security.server.model.AiOrderThirdLevel;
import com.boot.security.server.model.Dict;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class AiOrderThirdLevel2AiOrderThirdLevelDto {

    public static void aiOrderThirdLevelAiOrderThirdLevelDto(DictDao dictDao, List<AiOrderThirdLevel> aiOrderThirdLevels,
                                                             List<AiOrderThirdLevelDto> aiOrderThirdLevelDtos){

        List<Dict> aiBoxTypeList = dictDao.listByType("AiBoxType");
        List<Dict> aiProductTypeidList = dictDao.listByType("productTypeId");
        List<Dict> aiDataStateList = dictDao.listByType("dataState");
        for (AiOrderThirdLevel a:aiOrderThirdLevels
             ) {
            AiOrderThirdLevelDto aiOrderThirdLevelDto = new AiOrderThirdLevelDto();
            BeanUtils.copyProperties(a,aiOrderThirdLevelDto);
            aiOrderThirdLevelDto.setBoxtype(String.valueOf(a.getBoxtype()));
            aiOrderThirdLevelDto.setProducttypeid(String.valueOf(a.getProducttypeid()));
            for (Dict d:aiBoxTypeList
                 ) {
                if(aiOrderThirdLevelDto.getBoxtype().equals(d.getK())){
                    aiOrderThirdLevelDto.setBoxtype(d.getVal());
                }
            }
            for (Dict d:aiProductTypeidList
            ) {
                if(aiOrderThirdLevelDto.getProducttypeid().equals(d.getK())){
                    aiOrderThirdLevelDto.setProducttypeid(d.getVal());
                }
            }
            for (Dict d:aiDataStateList
            ) {
                if(aiOrderThirdLevelDto.getDatastate().equals(d.getK())){
                    aiOrderThirdLevelDto.setDatastate(d.getVal());
                }
            }
            aiOrderThirdLevelDtos.add(aiOrderThirdLevelDto);
        }
    }
}
