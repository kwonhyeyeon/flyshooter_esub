package com.fly.member.join.vo;

import com.fly.paging.vo.PagingVO;

//memberVO
public class MemberVO extends PagingVO {
	private String m_id;// 아이디
	private String m_pw;// 비밀번호
	private String m_phone;// 휴대전화
	private String m_name;// 회원명
	private String m_regdate;
	private int m_type = 3;// 회원 유형
	private String email_comfirm;// 이메일 인증 상태
	private String m_status;
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_regdate() {
		return m_regdate;
	}
	public void setM_regdate(String m_regdate) {
		this.m_regdate = m_regdate;
	}
	public int getM_type() {
		return m_type;
	}
	public void setM_type(int m_type) {
		this.m_type = m_type;
	}
	public String getEmail_comfirm() {
		return email_comfirm;
	}
	public void setEmail_comfirm(String email_comfirm) {
		this.email_comfirm = email_comfirm;
	}
	public String getM_status() {
		return m_status;
	}
	public void setM_status(String m_status) {
		this.m_status = m_status;
	}
	@Override
	public String toString() {
		return "MemberVO [getM_id()=" + getM_id() + ", getM_pw()=" + getM_pw() + ", getM_phone()=" + getM_phone()
				+ ", getM_name()=" + getM_name() + ", getM_regdate()=" + getM_regdate() + ", getM_type()=" + getM_type()
				+ ", getEmail_comfirm()=" + getEmail_comfirm() + ", getM_status()=" + getM_status() + "]";
	}


}
