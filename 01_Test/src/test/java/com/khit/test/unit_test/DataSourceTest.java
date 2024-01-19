package com.khit.test.unit_test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
public class DataSourceTest {
	
	@Autowired
	private DataSource ds;
	
	@Test
	public void testDataSource() {
		try {
			Connection con = ds.getConnection();
			log.info("연결 객체 생성 " + con);
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
