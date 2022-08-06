package product_service.repository.productColor;


import online_shop_jar.respository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import product_service.entity.color.Color;
import product_service.entity.product.Product;
import product_service.entity.product.ProductColor;

import java.util.Optional;


@Repository
public interface ProductColorRepository extends JpaRepository<ProductColor,Integer> , AbstractRepository {
    @Query("select p from Product p where p.id = :product")
    Optional<Product> getProduct(Integer product);

    @Query("select p from Color  p where p.id = : color")
    Optional<Color> getColor(Integer color);
}
