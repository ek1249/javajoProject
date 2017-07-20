package com.javajo.vo;

import java.util.Date;

public class PostboardVo {

	private int postboard_number;
	private String postboard_title;
	private String postboard_pwd;
	private String postboard_content;
	private int postboard_hit;
	private Date postboard_regdate;
	private String postboard_ip;
	private int postboard_p_ref;
	private int postboard_p_level;
	private int postboard_p_step;
	private String postboard_fname;
	private String postboard_type;
	private String customer_id;
	public PostboardVo(int postboard_number, String postboard_title, String postboard_pwd,
			String postboard_content, int postboard_hit, Date postboard_regdate, String postboard_ip,
			int postboard_p_ref, int postboard_p_level, int postboard_p_step, String postboard_fname, 
			String postboard_type, String customer_id) {
		super();
		this.postboard_number = postboard_number;
		this.postboard_title = postboard_title;
		this.postboard_pwd = postboard_pwd;
		this.postboard_content = postboard_content;
		this.postboard_hit = postboard_hit;
		this.postboard_regdate = postboard_regdate;
		this.postboard_ip = postboard_ip;
		this.postboard_p_ref = postboard_p_ref;
		this.postboard_p_level = postboard_p_level;
		this.postboard_p_step = postboard_p_step;
		this.postboard_fname = postboard_fname;
		this.postboard_type = postboard_type;
		this.customer_id = customer_id;
	}
	public PostboardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPostboard_number() {
		return postboard_number;
	}
	public void setPostboard_number(int postboard_number) {
		this.postboard_number = postboard_number;
	}
	public String getPostboard_title() {
		return postboard_title;
	}
	public void setPostboard_title(String postboard_title) {
		this.postboard_title = postboard_title;
	}
	public String getPostboard_pwd() {
		return postboard_pwd;
	}
	public void setPostboard_pwd(String postboard_pwd) {
		this.postboard_pwd = postboard_pwd;
	}
	public String getPostboard_content() {
		return postboard_content;
	}
	public void setPostboard_content(String postboard_content) {
		this.postboard_content = postboard_content;
	}
	public int getPostboard_hit() {
		return postboard_hit;
	}
	public void setPostboard_hit(int postboard_hit) {
		this.postboard_hit = postboard_hit;
	}
	public Date getPostboard_regdate() {
		return postboard_regdate;
	}
	public void setPostboard_regdate(Date postboard_regdate) {
		this.postboard_regdate = postboard_regdate;
	}
	public String getPostboard_ip() {
		return postboard_ip;
	}
	public void setPostboard_ip(String postboard_ip) {
		this.postboard_ip = postboard_ip;
	}
	public int getPostboard_p_ref() {
		return postboard_p_ref;
	}
	public void setPostboard_p_ref(int postboard_p_ref) {
		this.postboard_p_ref = postboard_p_ref;
	}
	public int getPostboard_p_level() {
		return postboard_p_level;
	}
	public void setPostboard_p_level(int postboard_p_level) {
		this.postboard_p_level = postboard_p_level;
	}
	public int getPostboard_p_step() {
		return postboard_p_step;
	}
	public void setPostboard_p_step(int postboard_p_step) {
		this.postboard_p_step = postboard_p_step;
	}
	public String getPostboard_fname() {
		return postboard_fname;
	}
	public void setPostboard_fname(String postboard_fname) {
		this.postboard_fname = postboard_fname;
	}
	public String getPostboard_type() {
		return postboard_type;
	}
	public void setPostboard_type(String postboard_type) {
		this.postboard_type = postboard_type;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	
	
}
