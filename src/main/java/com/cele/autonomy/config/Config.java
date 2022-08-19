package com.cele.autonomy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.cele.autonomy.annotation.BcProxyPostProcessor;

/**
 * Adding bean with scope = BeanDefinition.SCOPE_PROTOTYPE to instantiate new instance of different parameters
 *
 * @author mamadou_diouf
 *
 */
@Configuration
public class Config {

  @Bean
  public BcProxyPostProcessor bcProxyPostProcessor() {
    return new BcProxyPostProcessor();
  }


}
