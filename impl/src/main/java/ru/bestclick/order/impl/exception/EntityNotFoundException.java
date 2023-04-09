package ru.bestclick.order.impl.exception;

import ru.bestclick.exceptionlib.exception.BusinessException;


public class EntityNotFoundException extends BusinessException {

  public EntityNotFoundException(String code) {
    super(code);
  }

  public EntityNotFoundException(String code, String... details) {
    super(code, details);
  }
}