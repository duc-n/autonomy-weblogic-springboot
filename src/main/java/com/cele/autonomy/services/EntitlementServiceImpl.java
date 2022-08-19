package com.cele.autonomy.services;

import org.springframework.stereotype.Service;
import com.cele.autonomy.annotation.BcProxy;
import com.coface.corp.base.bdt.AccountTypeBDT;
import com.coface.corp.base.bdt.entitlement.AccountFullBDT;
import com.coface.corp.base.exception.EntityNotFoundException;
import com.coface.corp.entitlement.Entitlement;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EntitlementServiceImpl implements EntitlementService {

  @BcProxy
  Entitlement entitlement;

  @Override
  public String getAccountType(String accountName) {

    logger.debug("=> getAccountType : {}", accountName);

    try {
      AccountFullBDT account = entitlement.getAccount(accountName);
      AccountTypeBDT accountType = account.getAccountType();
      return accountType.getValue();

    } catch (EntityNotFoundException e) {
      logger.error("EntityNotFoundException error", e);
      return null;
    }

  }

}
