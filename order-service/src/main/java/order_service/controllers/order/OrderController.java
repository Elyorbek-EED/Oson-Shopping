package order_service.controllers.order;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import online_shop_jar.controller.AbstractController;
import online_shop_jar.response.DataDTO;
import order_service.criteria.order.OrderCriteria;
import order_service.dtos.order.OrderCreateDTO;
import order_service.dtos.order.OrderDTO;
import order_service.dtos.order.OrderUpdateDTO;
import order_service.dtos.order.OrderDTO;
import order_service.services.order.OrderServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Tag(name = "Order Controller", description = "APIs for Order CRUD")
public class OrderController extends AbstractController<OrderServiceImpl> {

    public OrderController(OrderServiceImpl service){
        super(service);
    }

    @Operation(summary = "Updating order")
    @RequestMapping(value = PATH + "/order/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<DataDTO<Void>> update(@RequestBody @Valid OrderUpdateDTO authUserCartUpdateDto) {
        return service.update(authUserCartUpdateDto);
    }

    @Operation(summary = "Getting order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully gotten",content = @Content(schema = @Schema(implementation = OrderDTO.class))),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Order was not found",content = @Content)})
    @RequestMapping(value = PATH + "/order/{id}", method = RequestMethod.GET)
    public ResponseEntity<DataDTO<OrderDTO>> getById(@Parameter(description = "id of order to be gotten",required = true)@PathVariable Integer id) {
        return service.get(id);
    }

    @Operation(summary = "Daleting order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted",content = @Content),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Order was not found",content = @Content)})
    @RequestMapping(value = PATH + "/order/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DataDTO<Void>> delete(@Parameter(description = "id of order to be deleted",required = true) @PathVariable Integer id) {
        return service.delete(id);
    }

    @Operation(summary = "Createing order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully saved",content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Conflict was occurred related to",content = @Content)})
    @RequestMapping(value = PATH + "/order/create", method = RequestMethod.POST)
    public ResponseEntity<DataDTO<Integer>> create(@RequestBody @Valid OrderCreateDTO authUserCartCreateDto) {
        return service.create(authUserCartCreateDto);
    }

    @Operation(summary = "Getting orders")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully gotten",content = @Content(schema = @Schema(implementation = OrderDTO.class))),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Order was not found",content = @Content)})
    @RequestMapping(value = PATH + "/order/orders", method = RequestMethod.GET)
    public ResponseEntity<DataDTO<List<OrderDTO>>> getCarts(@Valid OrderCriteria criteria) {
        return service.getAll(criteria);
    }

}
