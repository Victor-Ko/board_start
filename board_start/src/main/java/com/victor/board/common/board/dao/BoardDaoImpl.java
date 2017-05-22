package com.victor.board.common.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.victor.board.common.board.dto.BoardDto;
import com.victor.board.common.board.dto.FileDto;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao{

	@Autowired
	private SqlSession sqlSession;
	
	public void setSqlSessionTemplate(SqlSession sqlSession){
		this.sqlSession = sqlSession;
	}
	
	@Override
	public Integer insertBoard(BoardDto boardDto) {
		BoardDao boardDaoMapper = (BoardDao)sqlSession.getMapper(BoardDao.class);
		return boardDaoMapper.insertBoard(boardDto);
	}

	@Override
	public Integer updateBoard(BoardDto boardDto) {
		BoardDao boardDaoMapper = (BoardDao)sqlSession.getMapper(BoardDao.class);
		return boardDaoMapper.updateBoard(boardDto);
	}

	@Override
	public Integer deleteBoard(BoardDto boardDto) {
		BoardDao boardDaoMapper = (BoardDao)sqlSession.getMapper(BoardDao.class);
		return boardDaoMapper.deleteBoard(boardDto);
	}

	@Override
	public BoardDto selectBoard(BoardDto boardDto) {
		BoardDao boardDaoMapper = (BoardDao)sqlSession.getMapper(BoardDao.class);
		return boardDaoMapper.selectBoard(boardDto);
	}

	@Override
	public Integer insertComment(BoardDto boardDto) {
		BoardDao boardDaoMapper = (BoardDao)sqlSession.getMapper(BoardDao.class);
		return boardDaoMapper.insertComment(boardDto);
	}

	@Override
	public Integer updateComment(BoardDto boardDto) {
		BoardDao boardDaoMapper = (BoardDao)sqlSession.getMapper(BoardDao.class);
		return boardDaoMapper.updateComment(boardDto);
	}

	@Override
	public Integer deleteComment(BoardDto boardDto) {
		BoardDao boardDaoMapper = (BoardDao)sqlSession.getMapper(BoardDao.class);
		return boardDaoMapper.deleteComment(boardDto);
	}

	@Override
	public Integer uploadFile(FileDto fileDto) {
		BoardDao boardDaoMapper = (BoardDao)sqlSession.getMapper(BoardDao.class);
		return boardDaoMapper.uploadFile(fileDto);
	}

	@Override
	public Integer downloadFile(FileDto fileDto) {
		BoardDao boardDaoMapper = (BoardDao)sqlSession.getMapper(BoardDao.class);
		return boardDaoMapper.downloadFile(fileDto);
	}

}
