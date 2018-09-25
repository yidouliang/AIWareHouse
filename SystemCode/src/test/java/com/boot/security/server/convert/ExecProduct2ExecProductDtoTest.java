package com.boot.security.server.convert;

import com.boot.security.server.dao.ExecProductDao;
import com.boot.security.server.dto.ExecProductDto;
import com.boot.security.server.model.ExecProduct;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExecProduct2ExecProductDtoTest {

    @Autowired
    private ExecProductDao execProductDao;

    @Autowired
    private ExecProduct2ExecProductDto execProduct2ExecProductDto;

    @Test
    public void convert() {
        long id = 45;
        ExecProduct execProduct = execProductDao.getById(id);
        ExecProductDto execProductDto = execProduct2ExecProductDto.convert(execProduct);
        System.out.println(execProductDto.toString());
    }
}