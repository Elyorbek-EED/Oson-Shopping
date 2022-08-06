package order_service.criteria.shipping;

import lombok.*;
import online_shop_jar.criteria.GenericCriteria;
import org.springdoc.api.annotations.ParameterObject;

import javax.persistence.Column;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ParameterObject
public class ShippingCriteria implements GenericCriteria {
    @Column(name = "size", nullable = false, columnDefinition = "int default 5")
    private int size = 5;
    @Column(name = "page", nullable = false, columnDefinition = "int default 0")
    private int page = 0;
    private String sortBy;
    private String sortDirection;
}
