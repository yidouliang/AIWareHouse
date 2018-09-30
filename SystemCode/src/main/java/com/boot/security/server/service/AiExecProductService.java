package com.boot.security.server.service;

import com.boot.security.server.dto.ResponseInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created By Seven.wk
 * Description: 服务接口
 * Created At 2018/09/30
 */
public interface AiExecProductService {

    ResponseInfo importProduct(MultipartFile file) throws IOException;

}
