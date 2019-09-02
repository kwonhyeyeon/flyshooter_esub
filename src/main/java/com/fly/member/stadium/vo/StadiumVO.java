package com.fly.member.stadium.vo;



import java.sql.Timestamp;

import com.fly.member.place.vo.PlaceVO;

public class StadiumVO extends PlaceVO {
	private int s_no;
	private String s_name;
	private String s_size;
	private int s_d_fee;
	private int s_n_fee;
	private int s_d_fee_w;
	private int s_n_fee_w;
	private int s_people;
	private String s_img1;
	private String s_img2;
	private String s_img3;
	private String s_open;
	private String s_close;
	private int s_in_out;
	private int s_status;
	private Timestamp s_holiday;
	private Timestamp s_restart;
	private int s_hours;
	private Timestamp s_regdate;
	
	public StadiumVO() {
		super();
	}
	
	
	
	public StadiumVO(int s_no, String s_name, String s_size, int s_d_fee, int s_n_fee, int s_d_fee_w, int s_n_fee_w,
			int s_people, String s_img1, String s_img2, String s_img3, String s_open, String s_close, int s_in_out,
			int s_status, Timestamp s_holiday, Timestamp s_restart, int s_hours, Timestamp s_regdate) {
		super();
		this.s_no = s_no;
		this.s_name = s_name;
		this.s_size = s_size;
		this.s_d_fee = s_d_fee;
		this.s_n_fee = s_n_fee;
		this.s_d_fee_w = s_d_fee_w;
		this.s_n_fee_w = s_n_fee_w;
		this.s_people = s_people;
		this.s_img1 = s_img1;
		this.s_img2 = s_img2;
		this.s_img3 = s_img3;
		this.s_open = s_open;
		this.s_close = s_close;
		this.s_in_out = s_in_out;
		this.s_status = s_status;
		this.s_holiday = s_holiday;
		this.s_restart = s_restart;
		this.s_hours = s_hours;
		this.s_regdate = s_regdate;
	}



	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_size() {
		return s_size;
	}
	public void setS_size(String s_size) {
		this.s_size = s_size;
	}
	public int getS_d_fee() {
		return s_d_fee;
	}
	public void setS_d_fee(int s_d_fee) {
		this.s_d_fee = s_d_fee;
	}
	public int getS_n_fee() {
		return s_n_fee;
	}
	public void setS_n_fee(int s_n_fee) {
		this.s_n_fee = s_n_fee;
	}
	public int getS_d_fee_w() {
		return s_d_fee_w;
	}
	public void setS_d_fee_w(int s_d_fee_w) {
		this.s_d_fee_w = s_d_fee_w;
	}
	public int getS_n_fee_w() {
		return s_n_fee_w;
	}
	public void setS_n_fee_w(int s_n_fee_w) {
		this.s_n_fee_w = s_n_fee_w;
	}
	public int getS_people() {
		return s_people;
	}
	public void setS_people(int s_people) {
		this.s_people = s_people;
	}
	public String getS_img1() {
		return s_img1;
	}
	public void setS_img1(String s_img1) {
		this.s_img1 = s_img1;
	}
	public String getS_img2() {
		return s_img2;
	}
	public void setS_img2(String s_img2) {
		this.s_img2 = s_img2;
	}
	public String getS_img3() {
		return s_img3;
	}
	public void setS_img3(String s_img3) {
		this.s_img3 = s_img3;
	}
	public String getS_open() {
		return s_open;
	}
	public void setS_open(String s_open) {
		this.s_open = s_open;
	}
	public String getS_close() {
		return s_close;
	}
	public void setS_close(String s_close) {
		this.s_close = s_close;
	}
	public int getS_in_out() {
		return s_in_out;
	}
	public void setS_in_out(int s_in_out) {
		this.s_in_out = s_in_out;
	}
	public int getS_status() {
		return s_status;
	}
	public void setS_status(int s_status) {
		this.s_status = s_status;
	}
	public Timestamp getS_holiday() {
		return s_holiday;
	}
	public void setS_holiday(Timestamp s_holiday) {
		this.s_holiday = s_holiday;
	}
	public Timestamp getS_restart() {
		return s_restart;
	}
	public void setS_restart(Timestamp s_restart) {
		this.s_restart = s_restart;
	}
	public int getS_hours() {
		return s_hours;
	}
	public void setS_hours(int s_hours) {
		this.s_hours = s_hours;
	}
	public Timestamp getS_regdate() {
		return s_regdate;
	}
	public void setS_regdate(Timestamp s_regdate) {
		this.s_regdate = s_regdate;
	}
	
	
	
}
