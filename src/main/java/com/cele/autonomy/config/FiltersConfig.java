package com.cele.autonomy.config;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.cele.autonomy.security.SiteMinderServletFilter;

@Configuration
public class FiltersConfig {

  @Bean
  public FilterRegistrationBean<Filter> cacheControlFilter() {
    SiteMinderServletFilter siteMinderServletFilter = new SiteMinderServletFilter();

    return createFilterRegistration(siteMinderServletFilter);
  }

  private FilterRegistrationBean<Filter> createFilterRegistration(Filter filter) {
    FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<Filter>(filter);

    List<String> urlPatterns = new ArrayList<>();

    urlPatterns.add("/*");

    filterRegistrationBean.setUrlPatterns(urlPatterns);

    return filterRegistrationBean;
  }

}

