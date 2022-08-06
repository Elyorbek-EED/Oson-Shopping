package billing_service.repository.address;

import billing_service.entity.address.Street;
import online_shop_jar.respository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface StreetRepository extends JpaRepository<Street,Integer>, AbstractRepository {

}
