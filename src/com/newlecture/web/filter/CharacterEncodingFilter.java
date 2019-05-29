package com.newlecture.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(
		urlPatterns ={"/*"},
		initParams ={@WebInitParam(name="encoding", value="UTF-8")}
		)

public class CharacterEncodingFilter implements Filter{
	
	private String encoding= "UTF-8";//기본값 설정
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		String encoding = filterConfig.getInitParameter("encoding");//getinitparameter의 매개변수명과 xml의 init-param 이름과 같아야한다
		
		if(encoding != null && !encoding.equals(""))
			this.encoding = encoding;
	}//성성자는 아니지만 초기값을 설정하고 가져올 수 있다.
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("필터 사전 테스트");
		request.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);
		System.out.println("필터 사후 테스트");
		
	}
}
