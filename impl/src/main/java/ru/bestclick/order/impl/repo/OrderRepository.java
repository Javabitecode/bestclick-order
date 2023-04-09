package ru.bestclick.order.impl.repo;

import java.util.UUID;
import org.springframework.stereotype.Repository;
import ru.bestclick.order.impl.model.Order;

@Repository
public interface OrderRepository extends JooqCrudRepository<Order, UUID> {

}