package com.boot.security.server.service;

import com.boot.security.server.dto.ResponseInfo;
import com.boot.security.server.model.AiExecProduct;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created By Seven.wk
 * Description: 服务接口
 * Created At 2018/09/30
 */
public interface AiExecProductService {

    ResponseInfo importProduct(MultipartFile file, Long creatorId) throws IOException;

}

