package com.boot.security.server.service.impl;

import com.boot.security.server.dao.AiExecProductDao;
import com.boot.security.server.dto.ResponseInfo;
import com.boot.security.server.enums.SystemStatusEnum;
import com.boot.security.server.model.AiExecProduct;
import com.boot.security.server.service.AiExecProductService;
import com.boot.security.server.utils.ExcelUtil;
import com.boot.security.server.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created By Seven.wk
 * Description: 服务接口实现
 * Created At 2018/09/30
 */
@Service
public class AiExecProductServiceImpl implements AiExecProductService {

    @Value("${files.path}")
    private String filesPath;

    @Autowired
    private AiExecProductDao aiExecProductDao;

    @Override
    public ResponseInfo importProduct(MultipartFile file) throws IOException {
        String fullpath = filesPath + FileUtil.getPath() + file.getOriginalFilename();
        File excel = new File(FileUtil.saveFile(file, fullpath));
        if(!ExcelUtil.isExcel(excel)) {
            excel.delete();
            return new ResponseInfo(SystemStatusEnum.FILE_FORMAT_ERROR);
        }

        List<AiExecProduct> aiExecProductList = ExcelUtil.importAiExecProduct(excel);
        for(AiExecProduct aiExecProduct : aiExecProductList) {
            aiExecProductDao.save(aiExecProduct);
        }
        excel.delete();
        return new ResponseInfo("200", "数据导入成功");
    }
}
