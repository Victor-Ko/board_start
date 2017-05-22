package com.victor.board.common.member.service;

import com.victor.board.common.member.dto.MemberDto;

public interface MemberService {

	//유저 정보 셀렉트
	MemberDto selectUserInfo(MemberDto memberDto);
	
	//유저 정보 추가
	Integer insertUserInfo(MemberDto memberDto);
	
	//유저 정보 수정
	Integer updateUserInfo(MemberDto memberDto);
	
	//유저 정보 삭제
	Integer deleteUserInfo(MemberDto memberDto);
	
	//중복 유저 검색
	Integer checkUserInfo(MemberDto memberDto);
}
