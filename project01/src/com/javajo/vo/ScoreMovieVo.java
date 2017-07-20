package com.javajo.vo;

public class ScoreMovieVo {

	private int rownum;
	private String movie_name;
	private double movie_score;
	private String movie_image;
	public ScoreMovieVo(int rownum, String movie_name, double movie_score, String movie_image) {
		super();
		this.rownum = rownum;
		this.movie_name = movie_name;
		this.movie_score = movie_score;
		this.movie_image = movie_image;
	}
	public ScoreMovieVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public double getMovie_score() {
		return movie_score;
	}
	public void setMovie_score(double movie_score) {
		this.movie_score = movie_score;
	}
	public String getMovie_image() {
		return movie_image;
	}
	public void setMovie_image(String movie_image) {
		this.movie_image = movie_image;
	}
	
}
