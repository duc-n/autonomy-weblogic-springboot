package com.cele.autonomy.security;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import com.coface.corp.framework.sso.SSOClientHelper;
import com.coface.corp.framework.sso.SSOUserContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SiteMinderServletFilter implements Filter {

  @Override
  public void destroy() {
    // Do nothing
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    logger.debug("SM_USER Add user to header");
    HttpServletRequest req = (HttpServletRequest) request;
    if ((!req.getRequestURI().startsWith("/autonomyView/resources/") && !req.getRequestURI().startsWith("/autonomyView/EIPRedirect"))
        || req.getRequestURI().contains("index.html")) {
      HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(req);
      SSOUserContext userContext = SSOClientHelper.getAuthenticatedUserContext(req);

      logger.debug("SM_USER Add user to header");

      requestWrapper.addHeader("SM_USER", "FR1E2029");
      chain.doFilter(requestWrapper, response);

      if (null != userContext) {
        requestWrapper.addHeader("SM_USER", userContext.getEipUserName().toUpperCase());
        if (logger.isDebugEnabled()) {
          logger.debug("SM_USER={} added to the request header for uri {}", userContext.getEipUserName().toUpperCase(), req.getRequestURI());
        }

        chain.doFilter(requestWrapper, response);
      } else {
        chain.doFilter(request, response);
      }
    } else {
      chain.doFilter(request, response);
    }
  }

  @Override
  public void init(FilterConfig config) throws ServletException {

    logger.debug("SiteMinderServletFilter init");
    // Do nothing
  }

}
