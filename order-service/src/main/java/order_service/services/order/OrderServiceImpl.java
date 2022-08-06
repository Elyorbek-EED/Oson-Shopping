package order_service.services.order;

import online_shop_jar.response.DataDTO;
import online_shop_jar.service.AbstractService;
import online_shop_jar.service.BaseService;
import order_service.criteria.order.OrderCriteria;
import order_service.dtos.order.OrderCreateDTO;
import order_service.dtos.order.OrderDTO;
import order_service.dtos.order.OrderUpdateDTO;
import order_service.entity.cart.AuthUserCart;
import order_service.entity.order.Order;
import order_service.mappers.order.OrderMapper;
import order_service.repository.order.OrderRepository;
import order_service.validations.order.OrderValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl extends AbstractService<OrderRepository, OrderMapper, OrderValidator>
        implements OrderService <
        OrderDTO,
        OrderCreateDTO,
        OrderUpdateDTO,
        OrderCriteria,
        Integer> ,BaseService{

    public OrderServiceImpl(OrderRepository repository, OrderMapper mapper, OrderValidator validator) {
        super(repository, mapper, validator);
    }

    @Override
    public ResponseEntity<DataDTO<OrderDTO>> get(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDTO<Void>> delete(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDTO<Void>> update(OrderUpdateDTO updateDto) {
        return null;
    }

    @Override
    public ResponseEntity<DataDTO<Integer>> create(OrderCreateDTO createDto) {



        return null;
    }

    @Override
    public ResponseEntity<DataDTO<List<OrderDTO>>> getAll(OrderCriteria criteria) {
        return null;
    }
}
