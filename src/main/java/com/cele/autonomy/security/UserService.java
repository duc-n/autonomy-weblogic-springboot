package com.cele.autonomy.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import com.cele.autonomy.services.EntitlementService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService implements UserDetailsService {

  @Autowired
  private EntitlementService entitlementService;

  @Override
  public UserDetails loadUserByUsername(String username) {
    logger.debug("START loadUserByUsername : {}", username);
    User user = new User();
    user.setUsername(username);
    String accountType = entitlementService.getAccountType(username);

    logger.debug("loadUserByUsername. Account Type {}", accountType);

    logger.debug("END loadUserByUsername {} . user : {} ", username, user);

    return user;
  }



  /**
   * Verify the Peps Right related to this user
   *
   * @param user
   * @param pricingEntityCode
   * @return true if the coface user has the Peps right
   */
  public boolean hasPricingRight(User user) {
    return user.isPepsAuthorized();
  }

}
