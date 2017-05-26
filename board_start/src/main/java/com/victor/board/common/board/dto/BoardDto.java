package com.victor.board.common.board.dto;

public class BoardDto {

	private int boardSeq;
	private String userId;
	private String boardTitle;
	private int boardViews;
	private String boardRegDate;
	private String boardContents;
	
	private String comDetail;
	private String comRegDate;
	
	public int getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}
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
	public String getBoardRegDate() {
		return boardRegDate;
	}
	public void setBoardRegDate(String boardRegDate) {
		this.boardRegDate = boardRegDate;
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
		return "BoardDto [boardSeq=" + boardSeq + ", userId=" + userId + ", boardTitle=" + boardTitle + ", boardViews="
				+ boardViews + ", boardRegDate=" + boardRegDate + ", boardContents=" + boardContents + ", comDetail="
				+ comDetail + ", comRegDate=" + comRegDate + "]";
	}
	
}
