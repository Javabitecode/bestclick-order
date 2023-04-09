package ru.bestclick.order.impl.repo.impl;

import static java.util.Objects.isNull;
import static ru.bestclick.advertisement.Tables.T_ORDER;
import static ru.bestclick.exceptionlib.constant.MarkerConstants.REPOSITORY_MARKER;
import static ru.bestclick.order.impl.constant.ExceptionCodeConstant.ORDER_DELETE_ERROR_CODE;
import static ru.bestclick.order.impl.constant.ExceptionCodeConstant.ORDER_GET_ERROR_CODE;
import static ru.bestclick.order.impl.constant.ExceptionCodeConstant.ORDER_SAVE_ERROR_CODE;
import static ru.bestclick.order.impl.constant.ExceptionCodeConstant.ORDER_UPDATE_ERROR_CODE;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.bestclick.exceptionlib.exception.ServerException;
import ru.bestclick.order.impl.converter.OrderRecordConverter;
import ru.bestclick.order.impl.model.Order;
import ru.bestclick.order.impl.repo.OrderRepository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

  private final DSLContext context;
  private final OrderRecordConverter mapper;

  @Override
  public List<Order> getAll() {
    try {
      var orders = context.selectFrom(T_ORDER)
          .fetch(mapper);
      log.debug(REPOSITORY_MARKER, "getAll() order. Status: success");
      return orders;
    } catch (Exception ex) {
      log.error(REPOSITORY_MARKER, "Error getAll() the order, exception: ", ex);
      throw new ServerException(ORDER_GET_ERROR_CODE);
    }
  }

  @Override
  public Order getById(UUID id) {
    try {
      if (Objects.isNull(id)) {
        return null;
      }
      var orderRecord = context.selectFrom(
              T_ORDER)
          .where(T_ORDER.ID.eq(id))
          .fetchOne();
      if (isNull(orderRecord)) {
        return null;
      }
      var order = orderRecord.into(Order.class);
      log.debug(REPOSITORY_MARKER, "getById() order. Status: success. id: {}", order.getId());
      return order;
    } catch (Exception ex) {
      log.error(REPOSITORY_MARKER, "Error getById() the order id: {}, exception: ", id, ex);
      throw new ServerException(ORDER_GET_ERROR_CODE);
    }
  }

  @Override
  public void save(Order order) {
    try {
      if (Objects.isNull(order)) {
        return;
      }
      context.newRecord(T_ORDER, order).store();
      log.debug(REPOSITORY_MARKER, "save() order. Status: success. id: {}", order.getId());
    } catch (Exception ex) {
      log.error(REPOSITORY_MARKER, "Error save() the order: {}, exception: ", order, ex);
      throw new ServerException(ORDER_SAVE_ERROR_CODE);
    }
  }

  @Override
  public void update(Order order) {
    try {
      if (Objects.isNull(order)) {
        return;
      }
      context.update(T_ORDER)
          .set(context.newRecord(T_ORDER, order))
          .set(T_ORDER.UPDATE_DATE, OffsetDateTime.now())
          .where(T_ORDER.ID.eq(order.getId()))
          .execute();
      log.debug(REPOSITORY_MARKER, "update() order. Status: success. id: {}", order.getId());
    } catch (Exception ex) {
      log.error(REPOSITORY_MARKER, "Error update() the order: {}, exception: ", order, ex);
      throw new ServerException(ORDER_UPDATE_ERROR_CODE);
    }
  }

  @Override
  public void deleteById(UUID id) {
    try {
      if (Objects.isNull(id)) {
        return;
      }
      context.delete(T_ORDER)
          .where(T_ORDER.ID.eq(id))
          .execute();
      log.debug(REPOSITORY_MARKER, "deleteById() order. Status: success. id: {}", id);
    } catch (Exception ex) {
      log.error(REPOSITORY_MARKER, "Error deleteById() the order id: {}, exception: ", id, ex);
      throw new ServerException(ORDER_DELETE_ERROR_CODE);
    }
  }
}