package online_shop_jar.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public  class Auditable extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    protected Integer id;

    @CreatedBy
    @Column(name = "created_by")
    private Integer createBy;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime createdAt;

    @Convert(disableConversion = true)
    @Column(name = "updated_at")
    @LastModifiedDate
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "updated_by")
    @LastModifiedBy
    private Integer updatedBy;

    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    private boolean deleted;


}