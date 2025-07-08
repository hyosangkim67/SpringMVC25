
package org.zerock.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class TimeMapperTests {
	@Setter(onMethod_ = @Autowired)
	private TimeMapper timeMapper;

	@Test
	public void testGetTime() {
		log.info("타임매퍼 테스트 getname" + timeMapper.getClass().getName());
		log.info("타임매퍼 결과: " + timeMapper.getTime());
	}
	
	@Test
	public void testGetTime2() {
		log.info("타임매퍼 테스트 getname" + timeMapper.getClass().getName());
		log.info("타임매퍼 결과: " + timeMapper.getTime());
	}

}
