package com.boot.security.server;

import com.boot.security.server.controller.OrderThirdLevelController;
import com.boot.security.server.dao.OrderThirdLevelDao;
import com.boot.security.server.model.OrderThirdLevel;
import com.boot.security.server.page.table.PageTableRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SecurityApplicationTest {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Test
	public void password() {
		String string = passwordEncoder.encode("admin");
		System.out.println(string);
		System.out.println(string.length());
	}


}
