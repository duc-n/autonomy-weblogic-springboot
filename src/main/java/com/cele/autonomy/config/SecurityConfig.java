package com.cele.autonomy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;
import org.springframework.web.filter.GenericFilterBean;
import com.cele.autonomy.security.UserService;
import lombok.AllArgsConstructor;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private UserService userService;

  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/ping").permitAll().antMatchers("/resources/**").permitAll().anyRequest().authenticated();

  }

  @Autowired
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    super.configure(auth);
    auth.authenticationProvider(preAuthProvider());
  }

  private AuthenticationProvider preAuthProvider() {
    PreAuthenticatedAuthenticationProvider preAuthProvider = new PreAuthenticatedAuthenticationProvider();
    preAuthProvider.setPreAuthenticatedUserDetailsService(new UserDetailsByNameServiceWrapper<PreAuthenticatedAuthenticationToken>(userService));
    return preAuthProvider;
  }


  protected GenericFilterBean siteMinderFilter() throws Exception {
    RequestHeaderAuthenticationFilter filter = new RequestHeaderAuthenticationFilter();
    // Default value is SM_USER filter.setPrincipalRequestHeader("SM_USER")
    filter.setContinueFilterChainOnUnsuccessfulAuthentication(false);
    filter.setExceptionIfHeaderMissing(false);
    filter.setAuthenticationManager(authenticationManager());
    return filter;
  }

}
