package com.victor.board.common.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.board.common.member.dao.MemberDao;
import com.victor.board.common.member.dto.MemberDto;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDao memberDaoMapper;
	
	@Override
	public MemberDto selectUserInfo(MemberDto memberDto) {
		return memberDaoMapper.selectUserInfo(memberDto);
	}

	@Override
	public Integer insertUserInfo(MemberDto memberDto) {
		return memberDaoMapper.insertUserInfo(memberDto);
	}

	@Override
	public Integer updateUserInfo(MemberDto memberDto) {
		return memberDaoMapper.updateUserInfo(memberDto);
	}

	@Override
	public Integer deleteUserInfo(MemberDto memberDto) {
		return memberDaoMapper.deleteUserInfo(memberDto);
	}

	@Override
	public Integer checkUserInfo(MemberDto memberDto) {
		return memberDaoMapper.checkUserInfo(memberDto);
	}

}
