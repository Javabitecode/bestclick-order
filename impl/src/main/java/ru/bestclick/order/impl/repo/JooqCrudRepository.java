package ru.bestclick.order.impl.repo;

import java.util.List;

public interface JooqCrudRepository<R, ID> {

  List<R> getAll();

  R getById(ID id);

  void save(R r);

  void update(R entity);

  void deleteById(ID id);
}
