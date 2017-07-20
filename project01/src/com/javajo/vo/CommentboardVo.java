package com.javajo.vo;

public class CommentboardVo {

	private int commentboard_number;
	private String commentboard_content;
	private String commentboard_regdate;
	private int commentboard_c_ref;
	private int commentboard_c_level;
	private int commentboard_c_step;
	private int postboard_number;
	public CommentboardVo(int commentboard_number, String commentboard_content, String commentboard_regdate,
			int commentboard_c_ref, int commentboard_c_level, int commentboard_c_step, int postboard_number) {
		super();
		this.commentboard_number = commentboard_number;
		this.commentboard_content = commentboard_content;
		this.commentboard_regdate = commentboard_regdate;
		this.commentboard_c_ref = commentboard_c_ref;
		this.commentboard_c_level = commentboard_c_level;
		this.commentboard_c_step = commentboard_c_step;
		this.postboard_number = postboard_number;
	}
	public CommentboardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCommentboard_number() {
		return commentboard_number;
	}
	public void setCommentboard_number(int commentboard_number) {
		this.commentboard_number = commentboard_number;
	}
	public String getCommentboard_content() {
		return commentboard_content;
	}
	public void setCommentboard_content(String commentboard_content) {
		this.commentboard_content = commentboard_content;
	}
	public String getCommentboard_regdate() {
		return commentboard_regdate;
	}
	public void setCommentboard_regdate(String commentboard_regdate) {
		this.commentboard_regdate = commentboard_regdate;
	}
	public int getCommentboard_c_ref() {
		return commentboard_c_ref;
	}
	public void setCommentboard_c_ref(int commentboard_c_ref) {
		this.commentboard_c_ref = commentboard_c_ref;
	}
	public int getCommentboard_c_level() {
		return commentboard_c_level;
	}
	public void setCommentboard_c_level(int commentboard_c_level) {
		this.commentboard_c_level = commentboard_c_level;
	}
	public int getCommentboard_c_step() {
		return commentboard_c_step;
	}
	public void setCommentboard_c_step(int commentboard_c_step) {
		this.commentboard_c_step = commentboard_c_step;
	}
	public int getPostboard_number() {
		return postboard_number;
	}
	public void setPostboard_number(int postboard_number) {
		this.postboard_number = postboard_number;
	}
	
}
