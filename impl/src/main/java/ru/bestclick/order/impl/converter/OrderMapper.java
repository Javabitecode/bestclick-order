package ru.bestclick.order.impl.converter;

import static java.util.Objects.isNull;
import static ru.bestclick.order.impl.config.MapperConfig.MAPPER;
import static ru.bestclick.order.impl.constant.ExceptionCodeConstant.ORDER_CONVERT_ERROR_CODE;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import org.jooq.JSONB;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.bestclick.exceptionlib.exception.ServerException;
import ru.bestclick.order.api.dto.OrderDto;
import ru.bestclick.order.api.dto.TradingPlace;
import ru.bestclick.order.impl.model.Order;

@Mapper
public interface OrderMapper {

  @Mapping(target = "tradingPlace", expression = "java(convert(order))")
  OrderDto toDto(Order order);

  @Mapping(target = "tradingPlace", expression = "java(convert(orderDto))")
  Order toEntity(OrderDto orderDto);

  List<OrderDto> toListDto(List<Order> orders);

  List<Order> toListEntity(List<OrderDto> orders);

  default JSONB convert(OrderDto orderDto) {
    try {
      if (isNull(orderDto.getTradingPlace())) {
        return null;
      }
      var trading = MAPPER.writeValueAsString(orderDto.getTradingPlace());
      return JSONB.valueOf(trading);
    } catch (JsonProcessingException e) {
      throw new ServerException(ORDER_CONVERT_ERROR_CODE);
    }
  }

  default TradingPlace convert(Order order) {
    try {
      if (order.getTradingPlace() == null) {
        return null;
      }
      return MAPPER.readValue(order.getTradingPlace().data(), TradingPlace.class);
    } catch (JsonProcessingException e) {
      throw new ServerException(ORDER_CONVERT_ERROR_CODE);
    }
  }
}