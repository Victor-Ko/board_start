package com.victor.board.common.board.service;

import java.util.List;

import com.victor.board.common.board.dto.BoardDto;
import com.victor.board.common.board.dto.FileDto;

public interface BoardService {

	//게시글 등록
		Integer insertBoard(BoardDto boardDto);
		
		//게시글 수정
		Integer updateBoard(BoardDto boardDto);
		
		//게시글 삭제
		Integer deleteBoard(BoardDto boardDto);
		
		//게시글 검색
		BoardDto selectBoard(BoardDto boardDto);
		
		//코멘트 등록
		Integer insertComment(BoardDto boardDto);
		
		//코멘트 수정
		Integer updateComment(BoardDto boardDto);
		
		//코멘트 삭제
		Integer deleteComment(BoardDto boardDto);
		
		//파일 업로드
		Integer uploadFile(FileDto fileDto);
		
		//파일 다운로드
		Integer downloadFile(FileDto fileDto);
}
