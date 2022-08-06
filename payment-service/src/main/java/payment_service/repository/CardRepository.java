package payment_service.repository;

import online_shop_jar.respository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import payment_service.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer>, AbstractRepository {
}
