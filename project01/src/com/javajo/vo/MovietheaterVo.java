package com.javajo.vo;

public class MovietheaterVo {
   
   private int movietheater_number;
   private String movietheater_name;
   private String movietheater_loc;
   private String movietheater_event;
   private int movie_number;
   public MovietheaterVo(int movietheater_number, String movietheater_name, String movietheater_loc,
         String movietheater_event, int movie_number) {
      super();
      this.movietheater_number = movietheater_number;
      this.movietheater_name = movietheater_name;
      this.movietheater_loc = movietheater_loc;
      this.movietheater_event = movietheater_event;
      this.movie_number = movie_number;
   }
   public MovietheaterVo() {
      super();
      // TODO Auto-generated constructor stub
   }
   public int getMovietheater_number() {
      return movietheater_number;
   }
   public void setMovietheater_number(int movietheater_number) {
      this.movietheater_number = movietheater_number;
   }
   public String getMovietheater_name() {
      return movietheater_name;
   }
   public void setMovietheater_name(String movietheater_name) {
      this.movietheater_name = movietheater_name;
   }
   public String getMovietheater_loc() {
      return movietheater_loc;
   }
   public void setMovietheater_loc(String movietheater_loc) {
      this.movietheater_loc = movietheater_loc;
   }
   public String getMovietheater_event() {
      return movietheater_event;
   }
   public void setMovietheater_event(String movietheater_event) {
      this.movietheater_event = movietheater_event;
   }
   public int getMovie_number() {
      return movie_number;
   }
   public void setMovie_number(int movie_number) {
      this.movie_number = movie_number;
   }
   


}