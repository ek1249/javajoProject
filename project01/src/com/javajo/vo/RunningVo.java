package com.javajo.vo;

public class RunningVo {

		private int running_number;
		private int theater_number;
		private int movie_number; 
		private int movietheater_number; 
		private String running_date;
		private String running_start;
		public RunningVo(int running_number, int theater_number, int movie_number, int movietheater_number,
				String running_date, String running_start) {
			super();
			this.running_number = running_number;
			this.theater_number = theater_number;
			this.movie_number = movie_number;
			this.movietheater_number = movietheater_number;
			this.running_date = running_date;
			this.running_start = running_start;
		}
		public RunningVo() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getRunning_number() {
			return running_number;
		}
		public void setRunning_number(int running_number) {
			this.running_number = running_number;
		}
		public int getTheater_number() {
			return theater_number;
		}
		public void setTheater_number(int theater_number) {
			this.theater_number = theater_number;
		}
		public int getMovie_number() {
			return movie_number;
		}
		public void setMovie_number(int movie_number) {
			this.movie_number = movie_number;
		}
		public int getMovietheater_number() {
			return movietheater_number;
		}
		public void setMovietheater_number(int movietheater_number) {
			this.movietheater_number = movietheater_number;
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
		


}
