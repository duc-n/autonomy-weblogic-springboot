package com.cele.autonomy.security;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.RequestContextFilter;
import com.coface.corp.framework.sso.SSOClientHelper;
import com.coface.corp.framework.sso.SSOUserContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SiteMinderServletFilter extends RequestContextFilter {

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    HttpServletRequest req = request;
    if ((!req.getRequestURI().startsWith("/autonomyView/resources/") && !req.getRequestURI().startsWith("/autonomyView/EIPRedirect"))
        || req.getRequestURI().contains("index.html")) {
      HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(req);
      SSOUserContext userContext = SSOClientHelper.getAuthenticatedUserContext(req);
      if (null != userContext) {
        requestWrapper.addHeader("SM_USER", userContext.getEipUserName().toUpperCase());
        if (logger.isDebugEnabled()) {
          logger.debug("SM_USER={} added to the request header for uri {}", userContext.getEipUserName().toUpperCase(), req.getRequestURI());
        }

        filterChain.doFilter(requestWrapper, response);
      } else {
        filterChain.doFilter(request, response);
      }
    } else {
      filterChain.doFilter(request, response);
    }
  }


}
