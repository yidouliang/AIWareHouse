package com.boot.security.server.convert;

import com.boot.security.server.dao.DictDao;
import com.boot.security.server.dto.AiMktBoxVo;
import com.boot.security.server.model.AiMktBox;
import com.boot.security.server.model.Dict;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;

public class AiMktBoxVo2AiBox {


    public static void aiMktBoxVo2AiBox(AiMktBoxVo aiMktBoxVo, AiMktBox aiMktBox){

        String addr = aiMktBoxVo.getArea().replaceAll("/","")+aiMktBoxVo.getAddress();
        aiMktBoxVo.setAddress(addr);
        aiMktBoxVo.setCreateTime(new Date());
        aiMktBoxVo.setUpdateTime(new Date());
        BeanUtils.copyProperties(aiMktBoxVo,aiMktBox);
    }

    public static void aiMktBoxList2AiBoxList(DictDao dictDao,List<AiMktBoxVo> aiMktBoxVoList,List<AiMktBox> aiMktBoxList){

        List<Dict> aiBoxTypeDictList = dictDao.listByType("AiBoxType");
        List<Dict> AiBoxStatusDictList = dictDao.listByType("AiBoxStatus");
        List<Dict> payStateDictList = dictDao.listByType("payState");

        for(AiMktBox aiMktBox : aiMktBoxList){
                AiMktBoxVo aiMktBoxVo = new AiMktBoxVo();
                BeanUtils.copyProperties(aiMktBox,aiMktBoxVo);
                for(Dict d : aiBoxTypeDictList){
                    if(aiMktBox.getBoxtype().equals(d.getK())){
                        aiMktBoxVo.setAiBoxType(d.getVal());
                    }
                }
                for(Dict d : AiBoxStatusDictList){
                    if(aiMktBox.getStatus().equals(d.getK())){
                        aiMktBoxVo.setAiBoxStatus(d.getVal());
                    }
                }
                for(Dict d : payStateDictList){
                    if(aiMktBox.getPaystate().equals(d.getK())){
                        System.err.println(aiMktBox.getPaystate()+":"+d.getVal());
                        aiMktBoxVo.setPayState(d.getVal());
                    }
                }
            aiMktBoxVoList.add(aiMktBoxVo);
        }

    }

}
