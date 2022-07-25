package com.lol.analysis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.lol.analysis.interceptor.AdminInterceptor;
import com.lol.analysis.interceptor.LoginInterceptor;



@Configuration
public class LolConfig implements WebMvcConfigurer{
	@Autowired
	LoginInterceptor loginInterceptor;//로그인된 유저만 입장 
	
	@Autowired
	AdminInterceptor adminInterceptor;//관리자 권한 입장 
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
		.addPathPatterns("/**")
		.excludePathPatterns("/")
		.excludePathPatterns("/member/login.do")
		.excludePathPatterns("/member/signup.do")
		.excludePathPatterns("/member/ajax/**")
		.excludePathPatterns("/board/**")
		.excludePathPatterns("/public/**"); //css,js파일 위치
		
		registry.addInterceptor(adminInterceptor)
		.addPathPatterns("/member/list.do/*")
		.addPathPatterns("/member/update.do")
		.addPathPatterns("/member/delete.do");
		
	}
}
