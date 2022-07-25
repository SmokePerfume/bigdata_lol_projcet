package com.lol.analysis.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginInterceptor implements HandlerInterceptor{

	@Override//controller에 요청이 들어가기 전에 
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession();
		Object memVo_obj=session.getAttribute("memberVo");
		if(memVo_obj!=null) { //로그인됨
			return true;			
		}else {//로그인이 안됨
			response.sendRedirect("/member/login.do"); //확인필수
			return false;
		}
		
	}
	@Override//controller가 요청 처리가 끝난 후
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
	
	@Override//view 처리가 끝이나고 
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		response.getWriter().append("<script>console.log('afterCompletion 실행(interceptor)')</script>");
	}
}
