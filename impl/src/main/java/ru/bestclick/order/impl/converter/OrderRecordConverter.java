package ru.bestclick.order.impl.converter;

import org.jooq.Record;
import org.jooq.RecordMapper;
import org.mapstruct.Mapper;
import ru.bestclick.order.impl.model.Order;

@Mapper
public abstract class OrderRecordConverter implements RecordMapper<Record, Order> {

  @Override
  public Order map(Record orderRecord) {
    if (orderRecord == null) {
      return null;
    }
    return orderRecord.into(Order.class);
  }
}