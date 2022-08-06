package online_shop_jar.criteria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BaseCriteria implements GenericCriteria {
    private Integer size;
    private Integer page;

    public int getPage() {
        if (Objects.isNull(page))
            page = 0;
        return page;
    }

    public int getSize() {
        if (Objects.isNull(size))
            size = 10;
        return size;
    }
}
