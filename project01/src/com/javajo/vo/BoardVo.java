package com.javajo.vo;

import java.util.Date;

public class BoardVo {

	private int board_number;
	private String board_title;
	private String board_content;
	private Date board_regdate;
	private String board_fname;
	public BoardVo(int board_number, String board_title, String board_content, Date board_regdate, String board_fname,
			int board_fsize) {
		super();
		this.board_number = board_number;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_regdate = board_regdate;
		this.board_fname = board_fname;
	}
	public BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBoard_number() {
		return board_number;
	}
	public void setBoard_number(int board_number) {
		this.board_number = board_number;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public Date getBoard_regdate() {
		return board_regdate;
	}
	public void setBoard_regdate(Date board_regdate) {
		this.board_regdate = board_regdate;
	}
	public String getBoard_fname() {
		return board_fname;
	}
	public void setBoard_fname(String board_fname) {
		this.board_fname = board_fname;
	}
	
}
