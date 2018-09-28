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
        aiMktBox.setPaystate(Integer.valueOf(aiMktBoxVo.getPaystate()));
    }

    public static void aiMktBoxList2AiBoxList(DictDao dictDao,List<AiMktBoxVo> aiMktBoxVoList,List<AiMktBox> aiMktBoxList){

        List<Dict> aiBoxTypeDictList = dictDao.listByType("AiBoxType");
        List<Dict> AiBoxStatusDictList = dictDao.listByType("AiBoxStatus");
        List<Dict> payStateDictList = dictDao.listByType("payState");
        for(AiMktBox aiMktBox : aiMktBoxList){
                AiMktBoxVo aiMktBoxVo = new AiMktBoxVo();
                BeanUtils.copyProperties(aiMktBox,aiMktBoxVo);
                aiMktBoxVo.setPaystate(String.valueOf(aiMktBox.getPaystate()));
                for(Dict d : aiBoxTypeDictList){
                    if(aiMktBox.getBoxtype().equals(d.getK())){
                        aiMktBoxVo.setBoxtype(d.getVal());
                    }
                }
                for(Dict d : AiBoxStatusDictList){
                    if(aiMktBoxVo.getStatus().equals(d.getK())){
                        aiMktBoxVo.setStatus(d.getVal());
                    }
                }
                for(Dict d : payStateDictList){
                    if(aiMktBoxVo.getPaystate().equals(d.getK())){
                        aiMktBoxVo.setPaystate(d.getVal());
                    }
                }
            aiMktBoxVoList.add(aiMktBoxVo);
        }

    }

}
