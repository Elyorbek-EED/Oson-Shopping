package account_service.repository.authUser;

import account_service.entity.authUser.AuthUser;
import online_shop_jar.respository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Integer>, AbstractRepository {
}
