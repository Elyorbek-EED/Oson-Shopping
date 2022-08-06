package product_service.entity.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online_shop_jar.entity.Auditable;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
@Where(clause = "is_deleted is false")
public class Category extends Auditable {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,unique = true)
    private String code;

}
