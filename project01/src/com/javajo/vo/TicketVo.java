package com.javajo.vo;

import java.util.Date;

public class TicketVo {

	private int ticket_number;
	private Date ticket_date;
	private int ticket_peoplenum;
	private int movie_number;
	private int movietheater_number;
	private int theater_number;
	private String customer_id;
	public TicketVo(int ticket_number, Date ticket_date, int ticket_peoplenum, int movie_number,
			int movietheater_number, int theater_number, String customer_id) {
		super();
		this.ticket_number = ticket_number;
		this.ticket_date = ticket_date;
		this.ticket_peoplenum = ticket_peoplenum;
		this.movie_number = movie_number;
		this.movietheater_number = movietheater_number;
		this.theater_number = theater_number;
		this.customer_id = customer_id;
	}
	public TicketVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTicket_number() {
		return ticket_number;
	}
	public void setTicket_number(int ticket_number) {
		this.ticket_number = ticket_number;
	}
	public Date getTicket_date() {
		return ticket_date;
	}
	public void setTicket_date(Date ticket_date) {
		this.ticket_date = ticket_date;
	}
	public int getTicket_peoplenum() {
		return ticket_peoplenum;
	}
	public void setTicket_peoplenum(int ticket_peoplenum) {
		this.ticket_peoplenum = ticket_peoplenum;
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
	public int getTheater_number() {
		return theater_number;
	}
	public void setTheater_number(int theater_number) {
		this.theater_number = theater_number;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	
}
