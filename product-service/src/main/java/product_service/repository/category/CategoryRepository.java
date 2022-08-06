package product_service.repository.category;

import online_shop_jar.respository.AbstractRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import product_service.entity.category.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>, AbstractRepository {
}
