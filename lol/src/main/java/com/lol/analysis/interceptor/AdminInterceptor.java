package com.lol.analysis.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.lol.analysis.vo.MemberVo;


@Component
public class AdminInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession();
		Object memVo_obj=session.getAttribute("memberVo");
		System.out.println("AdminInterceptor.preHandler");
		if(memVo_obj!=null && ((MemberVo)memVo_obj).getGrade()<2 ) {
			return true;			
		}else {
			session.setAttribute("msg", "해당 페이지 접근 권한이 없습니다.(admin, super_admin)");
			response.sendRedirect("/");
			return false;
		}
	}

}
