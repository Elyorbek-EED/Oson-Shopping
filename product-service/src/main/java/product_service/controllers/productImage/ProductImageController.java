package product_service.controllers.productImage;

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
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import product_service.dtos.productImage.ProductImageCreateDTO;
import product_service.dtos.productImage.ProductImageDTO;
import product_service.dtos.productImage.ProductImageUpdateDTO;
import product_service.service.productImage.ProductImageServiceImpl;

import javax.validation.Valid;
import java.util.List;


@Service
public class ProductImageController extends AbstractController<ProductImageServiceImpl> {

    public ProductImageController(ProductImageServiceImpl service) {
        super(service);
    }

    @Operation(summary = "Getting product image")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully get list of department", content = @Content(schema = @Schema(implementation = ProductImageDTO.class))),
            @ApiResponse(responseCode = "400", description = "Category not exist for Product yet ", content = @Content),
            @ApiResponse(responseCode = "403", description = "Product or Image blocked", content = @Content),
            @ApiResponse(responseCode = "404", description = "Product or Image not found", content = @Content)})
    @GetMapping(value = PATH + "/product/image/list")
    public ResponseEntity<DataDTO<List<ProductImageDTO>>> getAll(BaseCriteria criteria) {
        return service.getAll(criteria);
    }

    @Operation(summary = "Getting product image")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully gotten",content = @Content(schema = @Schema(implementation = ProductImageDTO.class))),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Product or Image was not found",content = @Content)})
    @GetMapping(value = PATH + "/product/image/{id}")
    public ResponseEntity<DataDTO<ProductImageDTO>> getById(@Parameter(description = "id of product to be gotten", required = true) @PathVariable Integer id) {
        return service.get(id);
    }

    @Operation(summary = "Deleting product image")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted",content = @Content),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Product or Image was not found",content = @Content)})
    @GetMapping(value = PATH + "/product/image/delete/{id}")
    public ResponseEntity<DataDTO<Void>> delete(@Parameter(description = "id of product to be deleted", required = true) @PathVariable Integer id) {
        return service.delete(id);
    }

    @Operation(summary = "Creating product image")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully saved",content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Conflict was occurred related to",content = @Content)})
    @PostMapping(value = PATH + "/product/image/create")
    public ResponseEntity<DataDTO<Integer>> create(@RequestBody @Valid ProductImageCreateDTO productCreateDto) {
        return service.create(productCreateDto);
    }

    @Operation(summary = "Updating product image")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated",content = @Content(schema = @Schema(implementation = ProductImageDTO.class))),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Product or Image was not found",content = @Content)})
    @PutMapping(value = PATH + "/product/image/update")
    public ResponseEntity<DataDTO<Void>> update(@RequestBody @Valid ProductImageUpdateDTO productUpdateDto) {
        return service.update(productUpdateDto);
    }

}
