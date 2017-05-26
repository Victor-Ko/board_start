package com.victor.board.common.board.dao;

import java.util.List;

import com.victor.board.common.board.dto.BoardDto;
import com.victor.board.common.board.dto.FileDto;

public interface BoardDao {

	//게시글 추가
	Integer insertBoard(BoardDto boardDto);
	
	//게시글 수정
	Integer updateBoard(BoardDto boardDto);
	
	//게시글 삭제
	Integer deleteBoard(BoardDto boardDto);
	
	//게시판 메인화면 게시글 로딩
	List<BoardDto> selectBoard(BoardDto boardDto);
	
	//게시글 내용 로딩
	List<BoardDto> selectBoardDetail(BoardDto boardDto);
	
	//조회수 증가
	Integer updateViews(BoardDto boardDto);
	
	//코멘트 추가
	Integer insertComment(BoardDto boardDto);
	
	//코멘트 수정
	Integer updateComment(BoardDto boardDto);
	
	//코멘트 삭제
	Integer deleteComment(BoardDto boardDto);
	
	//파일 로딩
	List<FileDto> selectFile(FileDto fileDto);
		
	//파일 업로드
	Integer uploadFile(FileDto fileDto);
	
	//파일 다운로드
	Integer downloadFile(FileDto fileDto);
}
