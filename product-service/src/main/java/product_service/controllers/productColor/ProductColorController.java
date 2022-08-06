package product_service.controllers.productColor;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import online_shop_jar.controller.AbstractController;
import online_shop_jar.criteria.BaseCriteria;
import online_shop_jar.response.DataDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import product_service.dtos.productColor.ProductColorCreateDTO;
import product_service.dtos.productColor.ProductColorDTO;
import product_service.dtos.productColor.ProductColorUpdateDTO;
import product_service.service.productColor.ProductColorServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductColorController extends AbstractController<ProductColorServiceImpl> {

    public ProductColorController(ProductColorServiceImpl service) {
        super(service);
    }

    @Operation(summary = "Getting product color")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully get list of department", content = @Content(schema = @Schema(implementation = ProductColorDTO.class))),
            @ApiResponse(responseCode = "400", description = "Color not exist for Product yet ", content = @Content),
            @ApiResponse(responseCode = "404", description = "Product or Color not found", content = @Content)})
    @GetMapping(value = PATH + "/product/color/list")
    public ResponseEntity<DataDTO<List<ProductColorDTO>>> getAll(BaseCriteria criteria) {
        return service.getAll(criteria);
    }

    @Operation(summary = "Getting product color")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully gotten",content = @Content(schema = @Schema(implementation = ProductColorDTO.class))),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Product or Color was not found",content = @Content)})
    @GetMapping(value = PATH + "/product/color/{id}")
    public ResponseEntity<DataDTO<ProductColorDTO>> getById(@Parameter(description = "id of product to be gotten", required = true) @PathVariable Integer id) {
        return service.get(id);
    }

    @Operation(summary = "Deleting product color")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted",content = @Content),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Product or Color was not found",content = @Content)})
    @GetMapping(value = PATH + "/product/color/delete/{id}")
    public ResponseEntity<DataDTO<Void>> delete(@Parameter(description = "id of product to be deleted", required = true) @PathVariable Integer id) {
        return service.delete(id);
    }

    @Operation(summary = "Creating product color")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully saved",content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Conflict was occurred related to",content = @Content)})
    @PostMapping(value = PATH + "/product/color/create")
    public ResponseEntity<DataDTO<Integer>> create(@RequestBody @Valid ProductColorCreateDTO productCreateDto) {
        return service.create(productCreateDto);
    }

    @Operation(summary = "Updating product color")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated",content = @Content(schema = @Schema(implementation = ProductColorDTO.class))),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Product or Color was not found",content = @Content)})
    @PutMapping(value = PATH + "/product/color/update")
    public ResponseEntity<DataDTO<Void>> update(@RequestBody @Valid ProductColorUpdateDTO productUpdateDto) {
        return service.update(productUpdateDto);
    }

}
