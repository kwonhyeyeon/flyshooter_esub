package com.fly.admin.logadvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.ui.Model;

public class LoggingAdvice {

		public Object sessionChk(ProceedingJoinPoint pjp) throws Throwable {
			System.out.println("admin login chk");
			HttpServletRequest request = null;
			Model m = null;
			
			for(Object o : pjp.getArgs()) {
				if(o instanceof HttpServletRequest) {
					request = (HttpServletRequest) o;
				}else if(o instanceof Model) {
					m = (Model) o;
				}
			}
			
			if(request != null) {
				HttpSession session = request.getSession();
				String set = (String) session.getAttribute("adminId");
				
				if(set == null) {
					return "redirect:/admin/login.do";
				}
			}
			
			Object returnObj = pjp.proceed();
			
			
			return returnObj;
		}
}
