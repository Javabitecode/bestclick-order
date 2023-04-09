package ru.bestclick.order.impl.controller;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bestclick.order.api.controller.OrderController;
import ru.bestclick.order.api.dto.OrderDto;
import ru.bestclick.order.impl.converter.OrderMapper;
import ru.bestclick.order.impl.service.OrderService;

@Component
@RequiredArgsConstructor
public class OrderControllerImpl implements OrderController {

  private final OrderService service;
  private final OrderMapper mapper;

  @Override
  public List<OrderDto> getAll() {
    return mapper.toListDto(service.getAll());
  }

  @Override
  public OrderDto getById(UUID id) {
    return mapper.toDto(service.getById(id));
  }

  @Override
  public void save(OrderDto orderDto) {
    service.save(mapper.toEntity(orderDto));
  }

  @Override
  public void update(OrderDto orderDto, UUID id) {
    service.update(mapper.toEntity(orderDto), id);
  }

  @Override
  public void deleteById(UUID id) {
    service.deleteById(id);
  }
}