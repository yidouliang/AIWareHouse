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

	@Autowired
	private OrderThirdLevelDao orderThirdLevelDao;

	@Autowired
	private OrderThirdLevelController controller;

	@Test
	public void ortest(){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("orderBy","ORDER BY SID ASC");
		List<OrderThirdLevel> lists = orderThirdLevelDao.listThirdLevel(params,0,3,6L);
		for (OrderThirdLevel o:lists
			 ) {
			System.err.println("sid:"+o.getId());
		}
	}

//	@Test
//	public void ootest(){
//		PageTableRequest p = new PageTableRequest();
//		Map<String,Object> params = new HashMap<String,Object>();
//		params.put("orderBy","ORDER BY FIRST_LEVEL_ID ASC");
//		p.setLimit(3);
//		p.setParams(params);
//		p.setOffset(0);
//		List<OrderThirdLevel> lists = controller.list(p,6L);
//	}
}
