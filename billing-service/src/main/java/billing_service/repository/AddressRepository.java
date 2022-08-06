package billing_service.repository;

import billing_service.entity.address.Address;
import online_shop_jar.respository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>, AbstractRepository {
}
