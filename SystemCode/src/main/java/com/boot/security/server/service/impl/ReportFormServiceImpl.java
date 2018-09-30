package com.boot.security.server.service.impl;

import com.boot.security.server.dao.DictDao;
import com.boot.security.server.model.Dict;
import com.boot.security.server.service.ReportFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportFormServiceImpl implements ReportFormService {

    @Autowired
    private DictDao dictDao;

    @Override
    public List<String> getPayType() {
        List<Dict> payDicts = dictDao.listByType("aiOrderPayType");
        List<String> payTypes = new ArrayList<>();
        for (Dict d: payDicts
             ) {
            payTypes.add(d.getVal());
        }
        return payTypes;
    }
}
