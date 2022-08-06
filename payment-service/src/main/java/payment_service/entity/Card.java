package payment_service.entity;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cards")
@Where(clause = "is_deleted is false")
public class Card extends Auditable {
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "expiration_month_year")
    private String expirationMonthYear;
    private String name;
}
