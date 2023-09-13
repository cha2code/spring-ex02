package org.barista.service;

import java.util.List;

import org.barista.domain.BoardVO;
import org.barista.domain.Criteria;
import org.barista.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		
		log.info("register............" + board);
		
		mapper.insertSelectKey(board);

	}

	@Override
	public BoardVO get(Long bno) {
		
		log.info("get................." + bno);
		
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		
		log.info("modify.........." + board);
		
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		
		log.info("remove.........." + bno);
		
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		
		log.info("get List with criteria: " + cri);
		
		return mapper.getListWithPaging(cri);
	}

}

/*
 
 @Service
 
 - 해당 클래스를 root container에 bean 객체로 생성 
 - 서비스 레이어, 내부에서 JAVA 로직을 처리
 
 */