package com.cele.autonomy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cele.autonomy.services.EntitlementService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@AllArgsConstructor
public class ReceiveController {

  private EntitlementService entitlementService;

  @GetMapping("/ping")
  public String ping() {

    logger.debug("Ping Start !!");
    logger.warn("Ping warn start !!!");
    logger.info("Ping info start !!!");

    String accountType = entitlementService.getAccountType("X1220701");

    return accountType + "!!";
  }

  @GetMapping("/ping2")
  public String ping2() {

    logger.debug("Ping Start !!");
    logger.warn("Ping warn start !!");
    logger.info("Ping info start !!");

    String accountType = entitlementService.getAccountType("X1220701");

    return accountType;
  }
}
