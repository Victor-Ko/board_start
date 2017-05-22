package com.victor.board.common.board.dto;

public class BoardDto {

	private String userId;
	private String boardTitle;
	private int boardViews;
	private String regDate;
	private String boardContents;
	
	private String comDetail;
	private String comRegDate;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public int getBoardViews() {
		return boardViews;
	}
	public void setBoardViews(int boardViews) {
		this.boardViews = boardViews;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getBoardContents() {
		return boardContents;
	}
	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}
	public String getComDetail() {
		return comDetail;
	}
	public void setComDetail(String comDetail) {
		this.comDetail = comDetail;
	}
	public String getComRegDate() {
		return comRegDate;
	}
	public void setComRegDate(String comRegDate) {
		this.comRegDate = comRegDate;
	}
	@Override
	public String toString() {
		return "BoardDto [userId=" + userId + ", boardTitle=" + boardTitle + ", boardViews=" + boardViews + ", regDate="
				+ regDate + ", boardContents=" + boardContents + ", comDetail=" + comDetail + ", comRegDate="
				+ comRegDate + "]";
	}
	
	
	
	
}
