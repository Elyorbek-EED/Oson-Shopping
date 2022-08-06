package product_service.entity.product;

import lombok.*;
import online_shop_jar.entity.Auditable;
import org.hibernate.annotations.Where;
import product_service.entity.category.Category;
import product_service.enums.status.Status;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
@Where(clause = "is_deleted is false")
public class Product extends Auditable {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category")
    private Category category;
    private String name;
    private String description;
    private Double price;
    @Enumerated(EnumType.STRING)
    private Status status;


}
