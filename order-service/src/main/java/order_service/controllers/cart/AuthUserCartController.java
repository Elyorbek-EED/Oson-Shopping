package order_service.controllers.cart;


import order_service.criteria.cart.AuthUserCartCriteria;
import order_service.dtos.cart.AuthUserCartCreateDTO;
import order_service.dtos.cart.AuthUserCartDTO;
import order_service.dtos.cart.AuthUserCartUpdateDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import online_shop_jar.controller.AbstractController;
import online_shop_jar.response.DataDTO;
import order_service.services.cart.AuthUserCartServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@Tag(name = "AuthUserCart Controller", description = "APIs for AuthUser Cart CRUD")
public class AuthUserCartController extends AbstractController<AuthUserCartServiceImpl> {

    public AuthUserCartController(AuthUserCartServiceImpl service) {
        super(service);
    }

    @Operation(summary = "Updating cart")
    @RequestMapping(value = PATH + "/cart/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<DataDTO<Void>> update(@RequestBody @Valid AuthUserCartUpdateDTO authUserCartUpdateDto) {
        return service.update(authUserCartUpdateDto);
    }

    @Operation(summary = "Getting cart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully gotten",content = @Content(schema = @Schema(implementation = AuthUserCartDTO.class))),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "AuthUserCart was not found",content = @Content)})
    @RequestMapping(value = PATH + "/cart/{id}", method = RequestMethod.GET)
    public ResponseEntity<DataDTO<AuthUserCartDTO>> getById(@Parameter(description = "id of cart to be gotten",required = true)@PathVariable Integer id) {
        return service.get(id);
    }

    @Operation(summary = "Daleting cart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted",content = @Content),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "AuthUserCart was not found",content = @Content)})
    @RequestMapping(value = PATH + "/cart/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DataDTO<Void>> delete(@Parameter(description = "id of cart to be deleted",required = true) @PathVariable Integer id) {
        return service.delete(id);
    }

    @Operation(summary = "Createing cart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully saved",content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Conflict was occurred related to",content = @Content)})
    @RequestMapping(value = PATH + "/cart/create", method = RequestMethod.POST)
    public ResponseEntity<DataDTO<Integer>> create(@RequestBody @Valid AuthUserCartCreateDTO authUserCartCreateDto) {
        return service.create(authUserCartCreateDto);
    }

    @Operation(summary = "Getting carts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully gotten",content = @Content(schema = @Schema(implementation = AuthUserCartDTO.class))),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "AuthUserCart was not found",content = @Content)})
    @RequestMapping(value = PATH + "/cart/carts", method = RequestMethod.GET)
    public ResponseEntity<DataDTO<List<AuthUserCartDTO>>> getCarts(@Valid AuthUserCartCriteria criteria) {
        return service.getAll(criteria);
    }

}