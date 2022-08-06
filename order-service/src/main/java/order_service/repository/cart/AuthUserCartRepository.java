package order_service.repository.cart;



import online_shop_jar.respository.AbstractRepository;
import order_service.entity.cart.AuthUserCart;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface AuthUserCartRepository extends JpaRepository<AuthUserCart,Integer> , AbstractRepository {


}
