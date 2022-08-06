package product_service.entity.color;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online_shop_jar.entity.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "color")
public class Color extends Auditable {
    @Column(nullable = false)
    private String name;
    @Column(unique = true,nullable = false)
    private String code;
}
