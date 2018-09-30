package com.boot.security.server.convert;

import com.boot.security.server.dao.DictDao;
import com.boot.security.server.dto.AiConsumerDto;
import com.boot.security.server.model.AiConsumer;
import com.boot.security.server.model.Dict;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AiConsumer2AiConsumerDto {



    public static void aiConsumerList2AiConsumerDtoList(List<AiConsumer> aiConsumers, List<AiConsumerDto> aiConsumerDtos,DictDao dictDao){

        List<Dict> AiConsumerTypeList = dictDao.listByType("AiConsumerType");
        List<Dict> AiConsumerStateList = dictDao.listByType("AiConsumerState");
        List<Dict> AiConsumerSourceList = dictDao.listByType("AiConsumerSource");

        for (AiConsumer aiConsumer: aiConsumers
             ) {
            AiConsumerDto aiConsumerDto = new AiConsumerDto();
            BeanUtils.copyProperties(aiConsumer,aiConsumerDto);
            aiConsumerDto.setType(String.valueOf(aiConsumer.getType()));
            aiConsumerDto.setState(String.valueOf(aiConsumer.getState()));
            aiConsumerDto.setSource(String.valueOf(aiConsumer.getSource()));
            for (Dict d:AiConsumerTypeList
                 ) {
                if(aiConsumerDto.getType().equals(d.getK())){
                    aiConsumerDto.setType(d.getVal());
                }
            }
            for (Dict d:AiConsumerStateList
            ) {
                if(aiConsumerDto.getState().equals(d.getK())){
                    aiConsumerDto.setState(d.getVal());
                }
            }
            for (Dict d:AiConsumerSourceList
            ) {
                if(aiConsumerDto.getSource().equals(d.getK())){
                    aiConsumerDto.setSource(d.getVal());
                }
            }
            aiConsumerDtos.add(aiConsumerDto);
        }


    }
}
