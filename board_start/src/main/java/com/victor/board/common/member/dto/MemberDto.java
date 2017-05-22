package com.victor.board.common.member.dto;

public class MemberDto {

	private String userId;
	private String userPw;
	private String userFirstName;
	private String userLastName;
	private String userGender;
	private String userBirth;
	private String userAuth;
	private String userRegDate;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserAuth() {
		return userAuth;
	}
	public void setUserAuth(String userAuth) {
		this.userAuth = userAuth;
	}
	public String getUserRegDate() {
		return userRegDate;
	}
	public void setUserRegDate(String userRegDate) {
		this.userRegDate = userRegDate;
	}
	@Override
	public String toString() {
		return "MemberDto [userId=" + userId + ", userPw=" + userPw + ", userFirstName=" + userFirstName
				+ ", userLastName=" + userLastName + ", userGender=" + userGender + ", userBirth=" + userBirth
				+ ", userAuth=" + userAuth + ", userRegDate=" + userRegDate + "]";
	}
	
}
