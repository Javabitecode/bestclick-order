package ru.bestclick.order.impl.service.impl;

import static ru.bestclick.order.impl.constant.ExceptionCodeConstant.ORDER_NOT_FOUND_CODE;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.bestclick.order.impl.exception.EntityNotFoundException;
import ru.bestclick.order.impl.helper.ClockHelper;
import ru.bestclick.order.impl.model.Order;
import ru.bestclick.order.impl.repo.OrderRepository;
import ru.bestclick.order.impl.service.OrderService;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;
  private final ClockHelper clock;

  @Override
  public List<Order> getAll() {
    return orderRepository.getAll();
  }

  @Override
  public Order getById(UUID id) {
    var order = orderRepository.getById(id);
    if (Objects.isNull(order)) {
      throw new EntityNotFoundException(ORDER_NOT_FOUND_CODE);
    }
    return order;
  }

  @Override
  public void save(Order order) {
    var enrichedOrder = enrichmentOrder(order);
    orderRepository.save(enrichedOrder);
  }

  @Override
  public void update(Order order, UUID id) {
    order.setId(id);
    orderRepository.update(order);
  }

  @Override
  public void deleteById(UUID id) {
    orderRepository.deleteById(id);
  }

  private Order enrichmentOrder(Order order) {
    return order.toBuilder()
        .id(UUID.randomUUID())
        .createDate(clock.now())
        .updateDate(clock.now())
        .build();
  }
}