package product_service.entity.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import online_shop_jar.entity.Auditable;
import product_service.entity.color.Color;

/**
 * Created by Elyor Ergashov
 *
 * @author : elyor
 * @date : 15/06/22
 * @project : online-shop
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_color")
public class ProductColor extends Auditable {
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;
}
