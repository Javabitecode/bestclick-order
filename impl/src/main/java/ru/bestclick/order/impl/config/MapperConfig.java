package ru.bestclick.order.impl.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

  public static final ObjectMapper MAPPER = new ObjectMapper();
}