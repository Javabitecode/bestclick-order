package ru.bestclick.order.api.controller;

import static ru.bestclick.order.api.constant.EndpointConstant.ID_PATH;
import static ru.bestclick.order.api.constant.EndpointConstant.ORDERS;

import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bestclick.order.api.dto.OrderDto;

@RestController
@RequestMapping(ORDERS)
public interface OrderController {

  @GetMapping
  List<OrderDto> getAll();

  @GetMapping(ID_PATH)
  OrderDto getById(@PathVariable UUID id);

  @PostMapping
  void save(@RequestBody OrderDto orderDto);

  @PutMapping(ID_PATH)
  void update(@RequestBody OrderDto orderDto, @PathVariable UUID id);

  @DeleteMapping(ID_PATH)
  void deleteById(@PathVariable UUID id);
}