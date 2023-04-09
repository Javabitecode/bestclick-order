package ru.bestclick.order.impl.service;

import java.util.List;
import java.util.UUID;
import ru.bestclick.order.impl.model.Order;

public interface OrderService {

  List<Order> getAll();

  Order getById(UUID id);

  void save(Order order);

  void update(Order order, UUID id);

  void deleteById(UUID id);
}