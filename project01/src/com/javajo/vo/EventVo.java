package com.javajo.vo;

public class EventVo {
	private int event_no;
	private String customer_id;
	private String title;
	private String regdate;
	private String writer;
	private int hit;
	private String content;
	private String fname;
	public int getEvent_no() {
		return event_no;
	}
	public void setEvent_no(int event_no) {
		this.event_no = event_no;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public EventVo(int event_no, String customer_id, String title, String regdate, String writer, int hit,
			String content, String fname) {
		super();
		this.event_no = event_no;
		this.customer_id = customer_id;
		this.title = title;
		this.regdate = regdate;
		this.writer = writer;
		this.hit = hit;
		this.content = content;
		this.fname = fname;
	}
	public EventVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
}