package org.mbc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.mbc.domain.BoardVO;

public interface BoardMapper {
	@Select("SELECT * FROM tbl_board WHERE bno > 0")
	public List<BoardVO> getList();
	// bno > 0 pk로 선언되어있어 인덱싱으로 빠른 추출 가능
	
	// @로 간단한 쿼리문은 가능하나 복잡한 쿼리문은 버그가 있다
	
	public List<BoardVO> getList2();
	
	public void insertSelectKey(BoardVO board);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
	
	// 
}

