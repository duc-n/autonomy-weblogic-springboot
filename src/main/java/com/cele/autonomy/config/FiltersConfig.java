package com.cele.autonomy.config;

import javax.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.cele.autonomy.security.SiteMinderServletFilter;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class FiltersConfig {

  @Bean
  public FilterRegistrationBean<Filter> siteMinderServletFilter() {
    SiteMinderServletFilter siteMinderServletFilter = new SiteMinderServletFilter();
    logger.debug("Add SiteMinderServletFilter filter");
    return createFilterRegistration(siteMinderServletFilter);
  }

  private FilterRegistrationBean<Filter> createFilterRegistration(Filter filter) {
    FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<Filter>(filter);

    filterRegistrationBean.addUrlPatterns("/*");
    filterRegistrationBean.setOrder(1);

    return filterRegistrationBean;
  }

}

