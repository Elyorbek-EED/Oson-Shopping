package billing_service.entity.address;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import online_shop_jar.entity.BaseEntity;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Where(clause = "is_deleted is false")

public class Address extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "province")
    private Province province;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "district")
    private District district;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "street")
    private Street street;

    @Column(name = "home")
    private String home;

    @Column(name = "is_deleted",columnDefinition = "boolean default false")
    private boolean deleted;





}
