package com.cele.autonomy.security;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class CsrfSecurityRequestMatcher implements RequestMatcher {
  static final Logger logger = LoggerFactory.getLogger(CsrfSecurityRequestMatcher.class);

  private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");
  private Pattern allowedURLs = Pattern.compile("/ws/bccontract|/updateProduct|/updateDiagnosis|/open|/logout");

  @Override
  public boolean matches(HttpServletRequest request) {
    logger.debug("URI : {}", request.getRequestURI());
    if (allowedMethods.matcher(request.getMethod()).matches()) {
      return false;
    }

    Matcher matcher = allowedURLs.matcher(request.getRequestURI());
    if (matcher.find()) {
      logger.debug("Disable csrf security for request : {}", request.getRequestURI());
      return false;
    }

    return true;
  }
}
