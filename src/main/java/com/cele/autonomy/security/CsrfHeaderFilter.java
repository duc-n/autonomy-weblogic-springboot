package com.cele.autonomy.security;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

public class CsrfHeaderFilter extends OncePerRequestFilter {

  static final Logger LOG = LoggerFactory.getLogger(CsrfHeaderFilter.class);

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    if (!request.getRequestURI().startsWith("/autonomyView/resources/") && !request.getRequestURI().startsWith("/autonomyView/updateProduct")
        && !request.getRequestURI().startsWith("/autonomyView/refreshDerogationLevel") && !request.getRequestURI().startsWith("/autonomyView/logout")
        && !request.getRequestURI().startsWith("/autonomyView/updateDiagnosis")
        && !request.getRequestURI().startsWith("/autonomyView/refreshTemplateBdoc")) {
      CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
      if (csrf != null) {
        Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
        String token = csrf.getToken();
        if (cookie == null || (token != null && !token.equals(cookie.getValue()))) {
          cookie = new Cookie("XSRF-TOKEN", token);
          cookie.setPath(request.getContextPath());
          response.addCookie(cookie);
          LOG.debug("AUTONOMY VS - XSRF cookie added to the response for uri {}", request.getRequestURI());
        }
      }
    }
    filterChain.doFilter(request, response);
  }
}
