package product_service.criteria.product;

import lombok.*;
import org.springdoc.api.annotations.ParameterObject;

import javax.persistence.Column;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ParameterObject

public class ProductSortCriteria {
    @Column(name = "size", nullable = false, columnDefinition = "int default 5")
    private int size = 5;
    @Column(name = "page", nullable = false, columnDefinition = "int default 0")
    private int page = 0;


    protected String sortBy;

    protected String sortDirection;

    public String getSortDirection() {
        return sortDirection == null || sortDirection.equals("") ? " ASC " : sortDirection;
    }
}
