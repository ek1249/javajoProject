package com.javajo.vo;

public class RunningVo2 {
	
		private int running_number;
		private int theater_number;
		private int movie_number; 
		private int movietheater_number; 
		private String running_date;
		private String running_start;
		
		private int seat_number; 
		private String seat_row; 
		private String seat_column; 
		private String seat_ft; 
		private int ticket_number;
		private int seat_left;
		public RunningVo2(int running_number, int theater_number, int movie_number, int movietheater_number,
				String running_date, String running_start, int seat_number, String seat_row, String seat_column,
				String seat_ft, int ticket_number, int seat_left) {
			super();
			this.running_number = running_number;
			this.theater_number = theater_number;
			this.movie_number = movie_number;
			this.movietheater_number = movietheater_number;
			this.running_date = running_date;
			this.running_start = running_start;
			this.seat_number = seat_number;
			this.seat_row = seat_row;
			this.seat_column = seat_column;
			this.seat_ft = seat_ft;
			this.ticket_number = ticket_number;
			this.seat_left = seat_left;
		}
		public RunningVo2() {
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
		public int getSeat_number() {
			return seat_number;
		}
		public void setSeat_number(int seat_number) {
			this.seat_number = seat_number;
		}
		public String getSeat_row() {
			return seat_row;
		}
		public void setSeat_row(String seat_row) {
			this.seat_row = seat_row;
		}
		public String getSeat_column() {
			return seat_column;
		}
		public void setSeat_column(String seat_column) {
			this.seat_column = seat_column;
		}
		public String getSeat_ft() {
			return seat_ft;
		}
		public void setSeat_ft(String seat_ft) {
			this.seat_ft = seat_ft;
		}
		public int getTicket_number() {
			return ticket_number;
		}
		public void setTicket_number(int ticket_number) {
			this.ticket_number = ticket_number;
		}
		public int getSeat_left() {
			return seat_left;
		}
		public void setSeat_left(int seat_left) {
			this.seat_left = seat_left;
		}


}
