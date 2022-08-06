package order_service.repository.shipping;

import online_shop_jar.respository.AbstractRepository;
import order_service.entity.shipping.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping,Integer>, AbstractRepository {
}
