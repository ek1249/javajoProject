package com.javajo.vo;

public class RunningtableVo {

	private String movie_name;
	private String running_date;
	private String running_start;
	private String movie_image;
	public RunningtableVo(String movie_name, String running_date, String running_start, String movie_image) {
		super();
		this.movie_name = movie_name;
		this.running_date = running_date;
		this.running_start = running_start;
		this.movie_image = movie_image;
	}
	public RunningtableVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getRunning_date() {
		return running_date;
	}
	public void setRunning_date(String running_date) {
		this.running_date = running_date;
	}
	public String getRunning_start() {
		return running_start;
	}
	public void setRunning_start(String running_start) {
		this.running_start = running_start;
	}
	public String getMovie_image() {
		return movie_image;
	}
	public void setMovie_image(String movie_image) {
		this.movie_image = movie_image;
	}
	
}
