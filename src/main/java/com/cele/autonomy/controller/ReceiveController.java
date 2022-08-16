package com.cele.autonomy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ReceiveController {

  @GetMapping("/ping")
  public String ping() {

    logger.debug("Ping Start");
    logger.warn("Ping warn start");
    logger.info("Ping info start");
    return "Ping OK 2";
  }
}
