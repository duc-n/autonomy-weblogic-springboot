package com.cele.autonomy.security;

import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


@Component
public class AutonomyPermissionEvaluator implements PermissionEvaluator {



  static final Logger logger = LoggerFactory.getLogger(AutonomyPermissionEvaluator.class);

  @Override
  public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {

    logger.debug("START hasPermission");

    User user = (User) authentication.getPrincipal();

    if (null != permission) {
      logger.debug("permission : {}", permission);
      try {
        Object[] params = null;
        switch (PermissionEnum.valueOf((String) permission)) {


          default:
            break;
        }
      } catch (Exception e) {
        logger.error("Exception : ", e);
      }
    }
    return false;
  }

  @Override
  public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
    return false;
  }
}
