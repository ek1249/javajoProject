package com.javajo.vo;

public class HistoryVo {
	private String movie_name;
	private String running_date;
	private String running_start; 
	private String movietheater_name;
	private String movie_image;
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
	public String getMovietheater_name() {
		return movietheater_name;
	}
	public void setMovietheater_name(String movietheater_name) {
		this.movietheater_name = movietheater_name;
	}
	public String getMovie_image() {
		return movie_image;
	}
	public void setMovie_image(String movie_image) {
		this.movie_image = movie_image;
	}
	public HistoryVo(String movie_name, String running_date, String running_start, String movietheater_name,
			String movie_image) {
		super();
		this.movie_name = movie_name;
		this.running_date = running_date;
		this.running_start = running_start;
		this.movietheater_name = movietheater_name;
		this.movie_image = movie_image;
	}
	public HistoryVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
