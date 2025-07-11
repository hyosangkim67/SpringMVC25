package org.mbc.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mbc.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.java.Log;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board.toString()));
	}

	@Test
	public void testGetListXML() {
		mapper.getList2().forEach(board -> log.info(board.toString()));
	}

	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("ㄹ라");
		board.setContent("이니니");
		board.setWriter("집");
		mapper.insert(board); // BoardMapper에 정의 필요!
		log.info("새 글 등록 완료: " + board);
	}

	@Test
        public void testInsertSelectKey() {
        	BoardVO board = new BoardVO();
            board.setTitle("ㄹ라");
            board.setContent("이니니");
            board.setWriter("집");
            mapper.insertSelectKey(board);
            log.info(board);
            log.info("내가 만든 게시물의 번호는: " + board.getBno())
        }

	@Test
	public void testRead() {
		// 1번 게시물을 read 메서드로 보내고 객체로 받는다
		log.info(board);
	}

	@Test
	public void testDelete() {
		int count = mapper.delete(3L);
		log.info("삭제된 개수 출력" + count);

	}

	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(5L);
		board.setTitle("집가고시퍼");
		board.setContent("집집집지비집");
		board.setWriter("김수정이누구야");
		int count  = mapper.update(board);
		log.info("수정된 갯수는 " + count);
		log.info("수정된 객체 출f략: " + board);
		
	}
}

