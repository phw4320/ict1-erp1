package com.ict.erp;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LombokTest {

	@Test
	public void test() {
		TestVO tvo = new TestVO();
		tvo.setTest("abc");
		tvo.setT1("t1");
		tvo.setT2("t2");
		tvo.setT3("t3");
		tvo.setT4("t4");
		log.info("tvo=>{}", tvo);
		assertEquals(tvo.getTest(), "abc");
	}

}
