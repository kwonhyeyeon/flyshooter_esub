package com.fly.member.join.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fly.common.util.OpenCrypt;
import com.fly.common.util.Util;
import com.fly.member.join.dao.MemberDAO;
import com.fly.member.join.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	@Qualifier("memberDao")
	private MemberDAO memberDAO;

	@Override
	public int memberJoin(MemberVO mvo) {
		if (memberDAO.memberSelect(mvo.getM_id()) != null) {
			return 1;
		} else {
			try {
				mvo.setM_pw(new String(OpenCrypt.getSHA256(mvo.getM_pw(), Util.getRandomString())));
				memberDAO.memberJoin(mvo);
				return 3;
			} catch (RuntimeException e) {
				e.printStackTrace();
				return 2;
			}
		}
	}
	
	@Override
	public int userIdConfirm(String userId) {
		int result;
		if (memberDAO.memberSelect(userId) != null) {
			result = 1;
		} else {
			result = 2;
		}
		return result;
	}
	
	@Override
	public MemberVO memberSelect(String m_Id) {
		MemberVO vo = memberDAO.memberSelect(m_Id);
		return vo;
	}

	@Override
	public boolean memberUpdate(MemberVO mvo) {
		try {
			if (!mvo.getM_pw().isEmpty()) {
				String sec = memberDAO.securitySelect(mvo.getM_id());
				mvo.setM_pw(new String(OpenCrypt.getSHA256(mvo.getM_pw(), sec)));
			}
			memberDAO.memberUpdate(mvo);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public int memberDelete(String userId) {
		int isSucessCode = 3;
		try {
			isSucessCode = memberDAO.memberDelete(userId);
			isSucessCode = 2;
		} catch (Exception e) {
			e.printStackTrace();
			isSucessCode = 3;
		}
		return isSucessCode;

	}

	

}
