package com.cele.autonomy.config;

import javax.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.cele.autonomy.security.SiteMinderServletFilter;
import com.coface.corp.framework.sso.EIPRedirectServlet;
import com.coface.corp.framework.sso.SSOServletFilter;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class FiltersConfig {

  @Bean
  public FilterRegistrationBean<Filter> ssOServletFilter() {
    SSOServletFilter ssoServletFilter = new SSOServletFilter();

    logger.debug("Add SSOServletFilter filter");

    return createFilterRegistration(ssoServletFilter, 1);
  }

  @Bean
  public FilterRegistrationBean<Filter> siteMinderServletFilter() {
    SiteMinderServletFilter siteMinderServletFilter = new SiteMinderServletFilter();
    logger.debug("Add SiteMinderServletFilter filter");
    return createFilterRegistration(siteMinderServletFilter, 2);
  }


  @Bean
  public ServletRegistrationBean<EIPRedirectServlet> eIPRedirectServlet() {
    ServletRegistrationBean<EIPRedirectServlet> eIPRedirectServlet =
        new ServletRegistrationBean<EIPRedirectServlet>(new EIPRedirectServlet(), "/EIPRedirect/*");
    eIPRedirectServlet.setLoadOnStartup(1);
    return eIPRedirectServlet;
  }



  private FilterRegistrationBean<Filter> createFilterRegistration(Filter filter, int order) {
    FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<Filter>(filter);

    filterRegistrationBean.addUrlPatterns("/*");
    filterRegistrationBean.setOrder(order);

    return filterRegistrationBean;
  }

}

