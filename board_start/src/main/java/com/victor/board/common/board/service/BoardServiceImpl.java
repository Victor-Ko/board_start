package com.victor.board.common.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.board.common.board.dao.BoardDao;
import com.victor.board.common.board.dto.BoardDto;
import com.victor.board.common.board.dto.FileDto;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardDao boardDaoMapper;
	
	@Override
	public Integer insertBoard(BoardDto boardDto) {
		return boardDaoMapper.insertBoard(boardDto);
	}

	@Override
	public Integer updateBoard(BoardDto boardDto) {
		return boardDaoMapper.updateBoard(boardDto);
	}

	@Override
	public Integer deleteBoard(BoardDto boardDto) {
		return boardDaoMapper.deleteBoard(boardDto);
	}

	@Override
	public BoardDto selectBoard(BoardDto boardDto) {
		return boardDaoMapper.selectBoard(boardDto);
	}

	@Override
	public Integer insertComment(BoardDto boardDto) {
		return boardDaoMapper.insertComment(boardDto);
	}

	@Override
	public Integer updateComment(BoardDto boardDto) {
		return boardDaoMapper.updateComment(boardDto);
	}

	@Override
	public Integer deleteComment(BoardDto boardDto) {
		return boardDaoMapper.deleteComment(boardDto);
	}

	@Override
	public Integer uploadFile(FileDto fileDto) {
		return boardDaoMapper.uploadFile(fileDto);
	}

	@Override
	public Integer downloadFile(FileDto fileDto) {
		return boardDaoMapper.downloadFile(fileDto);
	}

}
