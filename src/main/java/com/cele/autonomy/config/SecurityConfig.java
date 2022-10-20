package com.cele.autonomy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;
import com.cele.autonomy.security.UserService;
import lombok.AllArgsConstructor;


@Configuration
@EnableWebSecurity(debug = true)
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserService userService;

  @Override
  protected void configure(final HttpSecurity http) throws Exception {

    http.addFilterAfter(siteminderFilter(), RequestHeaderAuthenticationFilter.class).authenticationProvider(preauthAuthProvider()).csrf().disable()
        .authorizeRequests().antMatchers("/resources/**").permitAll().antMatchers("/ping").permitAll().anyRequest().authenticated();

  }


  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(preauthAuthProvider());
  }

  @Bean(name = "siteminderFilter")
  public RequestHeaderAuthenticationFilter siteminderFilter() throws Exception {
    RequestHeaderAuthenticationFilter requestHeaderAuthenticationFilter = new RequestHeaderAuthenticationFilter();
    requestHeaderAuthenticationFilter.setPrincipalRequestHeader("SM_USER");
    requestHeaderAuthenticationFilter.setAuthenticationManager(authenticationManager());
    requestHeaderAuthenticationFilter.setInvalidateSessionOnPrincipalChange(true);
    requestHeaderAuthenticationFilter.setCheckForPrincipalChanges(true);
    return requestHeaderAuthenticationFilter;
  }


  // @Bean(name = "preAuthProvider")
  PreAuthenticatedAuthenticationProvider preauthAuthProvider() throws Exception {
    PreAuthenticatedAuthenticationProvider provider = new PreAuthenticatedAuthenticationProvider();
    provider.setPreAuthenticatedUserDetailsService(userDetailsServiceWrapper());
    return provider;
  }

  @Bean
  UserDetailsByNameServiceWrapper<PreAuthenticatedAuthenticationToken> userDetailsServiceWrapper() throws Exception {
    UserDetailsByNameServiceWrapper<PreAuthenticatedAuthenticationToken> wrapper = new UserDetailsByNameServiceWrapper<>();
    wrapper.setUserDetailsService(userService);
    return wrapper;
  }

}
