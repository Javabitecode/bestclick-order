package ru.bestclick.order.impl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.bestclick.exceptionlib.config.EnableExceptionHandler;

@SpringBootApplication
@EnableExceptionHandler
public class OrderApplication {

  public static void main(String[] args) {
    SpringApplication.run(OrderApplication.class, args);
  }
}