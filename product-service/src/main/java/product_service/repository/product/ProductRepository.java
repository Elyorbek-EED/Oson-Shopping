package product_service.repository.product;

import online_shop_jar.respository.AbstractRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import product_service.entity.category.Category;
import product_service.entity.product.Product;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, AbstractRepository {

    @Query(value = "select p from Product p where p.status = 'blocked'")
    Optional<List<Product>> getAllBlocked(Pageable pageable);


    @Query(value = "select p from Category p where p.id = :category")
    Optional<Category> findCategory(Integer category);

    @Query("select p from Product p where  p.name like concat( :word , '%') ")
    List<Product> findAllByNameContains(String word);


    @Query("select p from Product p where p.price >= :minPrice and p.price <= :maxPrice")
    Optional<Product> getProducts(Double maxPrice, Double minPrice);

    @Query(value = "select p.* from Product p where p.category = :category",nativeQuery = true)
    List<Product> getProductWithCategory(@Param("category") Integer category);

    @Query(value = "select p.* from Product p where p.id in (select pc.product_id from product_color pc where pc.color_id = :color)",nativeQuery = true)
    List<Product> getProductColors(Integer color);

    @Query(value = "select p.* from Product p where p.category = :category and p.price >= :minPrice and p.price <= :maxPrice and p.id in (select pc.product_id from product_color pc where pc.color_id = :color)",nativeQuery = true)
    List<Product> getProductCategoryAndPriceAndColor(Double maxPrice, Double minPrice, Integer category,Integer color);
    @Query(value = "select p.* from Product p where p.category = :category and p.price >= :minPrice and p.price <= :maxPrice",nativeQuery = true)
    List<Product> getProductWithCategoryAndPrice(Double maxPrice, Double minPrice, Integer category);
    @Query(value = "select p.* from Product p where p.price >= :minPrice and p.price <= :maxPrice and p.id in (select pc.product_id from product_color pc where pc.color_id = :color)",nativeQuery = true)
    List<Product> getProductPriceAndColor(Double maxPrice, Double minPrice, Integer color);

    @Query(value = "select p.* from Product p where p.category = :category and p.id in (select pc.product_id from product_color pc where pc.color_id = :color)",nativeQuery = true)
    List<Product> getProductCategoryAndColor(Integer category, Integer color);

//    @Query(value = "select t.*  from Product t order by t.price ASC offset :size * :page  limit :size", nativeQuery = true)
//    List<Product> sortByProductCriteria(String price, String sortDirection,Integer size,Integer page);
}
