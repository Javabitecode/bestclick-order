package ru.bestclick.order.impl.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ExceptionCodeConstant {

  public static final String ORDER_NOT_FOUND_CODE = "api.error.order.not.found";
  public static final String ORDER_SAVE_ERROR_CODE = "api.error.order.error.save";
  public static final String ORDER_UPDATE_ERROR_CODE = "api.error.order.error.update";
  public static final String ORDER_GET_ERROR_CODE = "api.error.order.error.get";
  public static final String ORDER_DELETE_ERROR_CODE = "api.error.order.error.delete";
  public static final String ORDER_CONVERT_ERROR_CODE = "api.error.order.error.convert";
}
