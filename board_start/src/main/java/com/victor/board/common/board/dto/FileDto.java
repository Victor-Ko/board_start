package com.victor.board.common.board.dto;

public class FileDto {
	
	private String fileName;
	private String fileExt;
	private double fileSize;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileExt() {
		return fileExt;
	}
	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}
	public double getFileSize() {
		return fileSize;
	}
	public void setFileSize(double fileSize) {
		this.fileSize = fileSize;
	}
	@Override
	public String toString() {
		return "FileDto [fileName=" + fileName + ", fileExt=" + fileExt + ", fileSize=" + fileSize + "]";
	}
	
	
	
}
