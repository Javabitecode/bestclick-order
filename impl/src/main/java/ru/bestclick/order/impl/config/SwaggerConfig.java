package ru.bestclick.order.impl.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Bean
  public GroupedOpenApi openApi() {
    return GroupedOpenApi
        .builder()
        .group("bestclick")
        .packagesToScan("ru/bestclick/order/impl/controller")
        .build();
  }
}