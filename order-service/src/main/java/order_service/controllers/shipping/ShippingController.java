package order_service.controllers.shipping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import online_shop_jar.controller.AbstractController;
import online_shop_jar.response.DataDTO;
import order_service.criteria.shipping.ShippingCriteria;
import order_service.dtos.shipping.ShippingCreateDTO;
import order_service.dtos.shipping.ShippingUpdateDTO;
import order_service.dtos.shipping.ShippingDTO;
import order_service.services.shipping.ShippingServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@Tag(name = "Shipping Controller", description = "APIs for Shipping CRUD")
public class ShippingController extends AbstractController<ShippingServiceImpl> {

    public ShippingController(ShippingServiceImpl service) {
        super(service);
    }

    @Operation(summary = "Updating shipping")
    @RequestMapping(value = PATH + "/shipping/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<DataDTO<Void>> update(@RequestBody @Valid ShippingUpdateDTO authUserCartUpdateDto) {
        return service.update(authUserCartUpdateDto);
    }

    @Operation(summary = "Getting shipping")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully gotten",content = @Content(schema = @Schema(implementation = ShippingDTO.class))),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Shipping was not found",content = @Content)})
    @RequestMapping(value = PATH + "/shipping/{id}", method = RequestMethod.GET)
    public ResponseEntity<DataDTO<ShippingDTO>> getById(@Parameter(description = "id of shipping to be gotten",required = true)@PathVariable Integer id) {
        return service.get(id);
    }

    @Operation(summary = "Daleting shipping")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted",content = @Content),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Shipping was not found",content = @Content)})
    @RequestMapping(value = PATH + "/shipping/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DataDTO<Void>> delete(@Parameter(description = "id of shipping to be deleted",required = true) @PathVariable Integer id) {
        return service.delete(id);
    }

    @Operation(summary = "Createing shipping")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully saved",content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Conflict was occurred related to",content = @Content)})
    @RequestMapping(value = PATH + "/shipping/create", method = RequestMethod.POST)
    public ResponseEntity<DataDTO<Integer>> create(@RequestBody @Valid ShippingCreateDTO authUserCartCreateDto) {
        return service.create(authUserCartCreateDto);
    }

    @Operation(summary = "Getting shippings")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully gotten",content = @Content(schema = @Schema(implementation = ShippingDTO.class))),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Shipping was not found",content = @Content)})
    @RequestMapping(value = PATH + "/shipping/shippings", method = RequestMethod.GET)
    public ResponseEntity<DataDTO<List<ShippingDTO>>> getCarts(@Valid ShippingCriteria criteria) {
        return service.getAll(criteria);
    }

}
