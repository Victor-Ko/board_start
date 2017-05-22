package com.victor.board.common.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.victor.board.common.member.dto.MemberDto;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private SqlSession sqlSession;
	
	public void setSqlSessionTemplate(SqlSession sqlSession){
		this.sqlSession = sqlSession;
	}
	
	@Override
	public MemberDto selectUserInfo(MemberDto memberDto) {
		MemberDao memberDaoMapper = (MemberDao)sqlSession.getMapper(MemberDao.class);
		return memberDaoMapper.selectUserInfo(memberDto);
	}

	@Override
	public Integer insertUserInfo(MemberDto memberDto) {
		MemberDao memberDaoMapper = (MemberDao)sqlSession.getMapper(MemberDao.class);
		return memberDaoMapper.insertUserInfo(memberDto);
	}

	@Override
	public Integer updateUserInfo(MemberDto memberDto) {
		MemberDao memberDaoMapper = (MemberDao)sqlSession.getMapper(MemberDao.class);
		return memberDaoMapper.updateUserInfo(memberDto);
	}

	@Override
	public Integer deleteUserInfo(MemberDto memberDto) {
		MemberDao memberDaoMapper = (MemberDao)sqlSession.getMapper(MemberDao.class);
		return memberDaoMapper.deleteUserInfo(memberDto);
	}

	@Override
	public Integer checkUserInfo(MemberDto memberDto) {
		MemberDao memberDaoMapper = (MemberDao)sqlSession.getMapper(MemberDao.class);
		return memberDaoMapper.checkUserInfo(memberDto);
	}

}
