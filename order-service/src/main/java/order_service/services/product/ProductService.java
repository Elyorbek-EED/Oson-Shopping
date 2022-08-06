package order_service.services.product;


import online_shop_jar.response.DataDTO;
import order_service.dtos.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("product-service")
@Service
public interface ProductService {

    @GetMapping("/product/{id}")
    ResponseEntity<DataDTO<ProductDTO>> getProduct(@RequestParam("id") Integer id);

}
