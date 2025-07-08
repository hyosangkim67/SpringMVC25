package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class) // 메서드 단위로 테스트용 코드
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
// 테스트 시 사용할 코드
@Log4j2 // Log4j는 취약하기에 2로 교체
public class HotelTests {
	@Setter(onMethod_ = @Autowired)
	private SampleHotel hotel ;
	
	public void testExist() {
		assertNotNull(hotel); // 객체가 null인지 판단
		// null이 아니어야 테스트가 성공
		log.info(hotel);
		log.info("----------------");
		log.info(hotel.getChef());
	}
}
