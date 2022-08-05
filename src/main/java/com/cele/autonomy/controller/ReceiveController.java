package com.cele.autonomy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiveController {

  @GetMapping("/ping")
  public String ping() {
    return "Ping OK 1";
  }
}
