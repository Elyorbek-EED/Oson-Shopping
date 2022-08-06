package order_service.repository.order;

import online_shop_jar.respository.AbstractRepository;
import order_service.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>, AbstractRepository {
}
