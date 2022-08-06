package account_service.criteria.authUser;

import lombok.*;
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
public class AuthUserCriteria implements Serializable {

    @Column(name = "size", nullable = false, columnDefinition = "int default 5")
    private int size = 5;
    @Column(name = "page", nullable = false, columnDefinition = "int default 0")
    private int page = 0;
    private String sortBy;
    private String sortDirection;
}
