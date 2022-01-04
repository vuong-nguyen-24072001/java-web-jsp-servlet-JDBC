package com.laptrinhjavaweb.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.utils.SessionUtil;

public class AuthorizationFilter implements javax.servlet.Filter {
	
	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String url = request.getRequestURI();
		if (url.startsWith(request.getContextPath() + "/admin")) {
			UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
			if (userModel != null) {
				String userRole = userModel.getRole().getCode();
				if (userRole.equals(SystemConstant.ADMIN)){
					filterChain.doFilter(request, response);
				} else if (userRole.equals(SystemConstant.USER)) {
					response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=no_permission&alert=danger");
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=need_login&alert=danger");
			}
		} else {
			filterChain.doFilter(servletRequest, servletResponse);
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
