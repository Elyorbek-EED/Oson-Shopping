package billing_service.entity.address;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online_shop_jar.entity.BaseEntity;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "street")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Where(clause = "is_deleted is false")

public class Street extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "district_id",nullable = false)
    private District district;

    @Column(name = "name", nullable = false)
    private String name;
}
