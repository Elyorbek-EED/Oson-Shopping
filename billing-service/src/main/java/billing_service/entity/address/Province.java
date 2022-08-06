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
@Table(name = "province")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Where(clause = "is_deleted is false")

public class Province extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "province")
    private Set<District> districts;

    @Column(name = "is_deleted",columnDefinition = "boolean default false")
    private boolean deleted;
    @Column(name = "name_uz",nullable = false,unique = true)
    private String nameUz;
    @Column(name = "name_krill",nullable = false,unique = true)
    private String nameKrill;
    @Column(name = "name_ru",nullable = false,unique = true)
    private String nameRu;
}
