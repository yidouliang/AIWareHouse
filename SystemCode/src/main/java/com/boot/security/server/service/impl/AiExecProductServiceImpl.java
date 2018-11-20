package com.boot.security.server.service.impl;

import com.boot.security.server.dao.AiExecProductDao;
import com.boot.security.server.dto.ResponseInfo;
import com.boot.security.server.enums.SystemStatusEnum;
import com.boot.security.server.exception.SystemException;
import com.boot.security.server.model.AiExecProduct;
import com.boot.security.server.model.SysUser;
import com.boot.security.server.service.AiExecProductService;
import com.boot.security.server.service.UserService;
import com.boot.security.server.utils.ExcelUtil;
import com.boot.security.server.utils.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created By Seven.wk
 * Description: 服务接口实现
 * Created At 2018/09/30
 */
@Service
public class AiExecProductServiceImpl implements AiExecProductService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${files.path}")
    private String filesPath;

    @Autowired
    private AiExecProductDao aiExecProductDao;

    @Override
    public ResponseInfo importProduct(MultipartFile file, Long creatorId) throws IOException {
        int batchSize = 1000;

        String fullPath = filesPath + FileUtil.getPath() + file.getOriginalFilename();
        File excel = new File(FileUtil.saveFile(file, fullPath));
        if(!ExcelUtil.isExcel(excel)) {
            excel.delete();
            return new ResponseInfo(SystemStatusEnum.FILE_FORMAT_ERROR);
        }

        List<AiExecProduct> aiExecProductList = ExcelUtil.importAiExecProduct(excel);

        for (AiExecProduct aiExecProduct : aiExecProductList) {
            aiExecProduct.setCreatorid(creatorId);
        }

        // 进行分段处理
        if (aiExecProductList.size() <= batchSize) {
            aiExecProductDao.bulkInsert(aiExecProductList);
        } else {
            int listSize = aiExecProductList.size();
            int num = listSize / batchSize;
            for(int i=0; i<num; i++) {
                aiExecProductDao.bulkInsert(aiExecProductList.subList(i*batchSize, (i+1)*batchSize));
            }
            aiExecProductDao.bulkInsert(aiExecProductList.subList(num*batchSize, listSize));
        }
        excel.delete();

        return new ResponseInfo("200", "数据导入成功");
    }

}
