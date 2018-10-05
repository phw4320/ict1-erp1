package com.ict.erp;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;

import com.zaxxer.hikari.HikariDataSource;

public class HikariTest {

	public static void main(String[] args) {

		HikariDataSource hds = new HikariDataSource();
		hds.setJdbcUrl("");
		hds.setUsername("ictu");
		hds.setPassword("12345678");
		hds.setDriverClassName("oracle.jdbc.OracleDriver");
		
		SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
		ssfb.setDataSource(hds);
		
		try {
			SqlSessionFactory ssf = ssfb.getObject();
			System.out.println(ssf);
			SqlSessionTemplate sst = new SqlSessionTemplate(ssf);
			System.out.println(sst);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
