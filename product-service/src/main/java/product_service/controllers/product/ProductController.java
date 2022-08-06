package product_service.controllers.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import online_shop_jar.controller.AbstractController;
import online_shop_jar.response.DataDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import product_service.criteria.product.ProductCriteria;
import product_service.criteria.product.ProductSortCriteria;
import product_service.dtos.product.FilterDTO;
import product_service.dtos.product.ProductCreateDTO;
import product_service.dtos.product.ProductDTO;
import product_service.dtos.product.ProductUpdateDTO;
import product_service.service.product.ProductServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@Tag(name = "Product Controller", description = "APIs for product CRUD")
public class ProductController extends AbstractController<ProductServiceImpl> {

    public ProductController(ProductServiceImpl service) {
        super(service);
    }

    @Operation(summary = "Getting product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully get list of department", content = @Content(schema = @Schema(implementation = ProductDTO.class))),
            @ApiResponse(responseCode = "400", description = "Category not exist for Product yet ", content = @Content),
            @ApiResponse(responseCode = "403", description = "Category blocked", content = @Content),
            @ApiResponse(responseCode = "404", description = "Category not found", content = @Content)})
    @GetMapping(value = PATH + "/product/list")
    public ResponseEntity<DataDTO<List<ProductDTO>>> getAll(ProductCriteria criteria) {
        return service.getAll(criteria);
    }

    @Operation(summary = "Getting product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully gotten", content = @Content(schema = @Schema(implementation = ProductCreateDTO.class))),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security", content = @Content),
            @ApiResponse(responseCode = "404", description = "Product was not found", content = @Content)})
    @GetMapping(value = PATH + "/product/{id}")
    public ResponseEntity<DataDTO<ProductDTO>> getById(@Parameter(description = "id of product to be gotten", required = true) @PathVariable Integer id) {
        return service.get(id);
    }

    @Operation(summary = "Deleting product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted", content = @Content),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security", content = @Content),
            @ApiResponse(responseCode = "404", description = "Product was not found", content = @Content)})
    @GetMapping(value = PATH + "/product/delete/{id}")
    public ResponseEntity<DataDTO<Void>> delete(@Parameter(description = "id of product to be deleted", required = true) @PathVariable Integer id) {
        return service.delete(id);
    }

    @Operation(summary = "Creating product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully saved", content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security", content = @Content),
            @ApiResponse(responseCode = "404", description = "Conflict was occurred related to", content = @Content)})
    @PostMapping(value = PATH + "/product/create")
    public ResponseEntity<DataDTO<Integer>> create(@RequestBody ProductCreateDTO productCreateDto) {
        return service.create(productCreateDto);
    }

    @Operation(summary = "Updating product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated", content = @Content(schema = @Schema(implementation = ProductCreateDTO.class))),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security", content = @Content),
            @ApiResponse(responseCode = "404", description = "Product was not found", content = @Content)})
    @PutMapping(value = PATH + "/product/update")
    public ResponseEntity<DataDTO<Void>> update(@RequestBody @Valid ProductUpdateDTO productUpdateDto) {
        return service.update(productUpdateDto);
    }

    @Operation(summary = "Blocking product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully blocked", content = @Content),
            @ApiResponse(responseCode = "400", description = "Product already blocked", content = @Content),
            @ApiResponse(responseCode = "404", description = "Product not found by id", content = @Content)})
    @PatchMapping(value = PATH + "/product/block/{id}")
    public ResponseEntity<DataDTO<Void>> block(@Parameter(description = "id of product to be blocked", required = true) @PathVariable Integer id) {
        return service.block(id);
    }

    @Operation(summary = "UnBlocking product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully unblocked", content = @Content),
            @ApiResponse(responseCode = "400", description = "Product was unblock", content = @Content),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)})
    @PatchMapping(value = PATH + "/product/unblock/{id}")
    public ResponseEntity<DataDTO<Void>> unBlock(@Parameter(description = "id of product to be unblocked", required = true) @PathVariable Integer id) {
        return service.unblock(id);
    }

    @Operation(summary = "Getting block list products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully get blocked list",
                    content = @Content(schema = @Schema(implementation = ProductDTO.class))),
            @ApiResponse(responseCode = "400", description = "Blocked Department not have for this ProductDTO yet ", content = @Content),
            @ApiResponse(responseCode = "403", description = "Category blocked ", content = @Content),
            @ApiResponse(responseCode = "404", description = "Category not found", content = @Content)})
    @GetMapping(value = PATH + "/product/blockList")
    public ResponseEntity<DataDTO<List<ProductDTO>>> blocklist(ProductCriteria criteria) {
        return service.blockList(criteria);
    }

    @Operation(summary = "Filer products")
    @GetMapping(value = PATH + "/product/filter")
    public ResponseEntity<DataDTO<List<ProductDTO>>> filter(FilterDTO filterDto) {
        return service.filter(filterDto);
    }

    @Operation(summary = "Search products")
    @GetMapping(value = PATH + "/product/search/{word}")
    public ResponseEntity<DataDTO<List<ProductDTO>>> search(@PathVariable String word) {
        return service.search(word);
    }

    @Operation(summary = "Sort products")
    @GetMapping(value = PATH + "/product/sort")
    public ResponseEntity<DataDTO<List<ProductDTO>>> getSort(ProductSortCriteria criteria) {
        return service.sort(criteria);
    }
}