package com.cele.autonomy.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import com.coface.corp.framework.sso.SSOClientHelper;

public class AutonomyLogoutSuccessHandler implements LogoutSuccessHandler {
	
	static final Logger logger = LoggerFactory.getLogger(AutonomyLogoutSuccessHandler.class);
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
					throws IOException, ServletException
	{
		logger.debug("Spring Security logout called");

		SSOClientHelper.backToPortal(request, response);
	}
}
