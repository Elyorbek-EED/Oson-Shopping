package product_service.repository.productImage;

import online_shop_jar.respository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import product_service.entity.product.ProductImage;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage,Integer>, AbstractRepository {
}
