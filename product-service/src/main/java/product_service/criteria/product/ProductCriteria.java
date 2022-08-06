package product_service.criteria.product;

import lombok.*;
import online_shop_jar.criteria.BaseCriteria;
import online_shop_jar.criteria.GenericCriteria;
import org.springdoc.api.annotations.ParameterObject;

import javax.persistence.Column;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ParameterObject

public class ProductCriteria extends BaseCriteria implements Serializable, GenericCriteria {
    @Column(name = "size", nullable = false, columnDefinition = "int default 5")
    private int size = 5;
    @Column(name = "page", nullable = false, columnDefinition = "int default 0")
    private int page = 0;



}
