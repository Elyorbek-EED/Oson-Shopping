package product_service.controllers.category;

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
import product_service.dtos.category.CategoryCreateDTO;
import product_service.dtos.category.CategoryDTO;
import product_service.dtos.category.CategoryUpdateDTO;
import product_service.service.category.CategoryServiceImpl;

import javax.validation.Valid;
import java.util.List;


@RestController
@Tag(name = "Category Controller", description = "APIs for category CRUD")
public class CategoryController extends AbstractController<CategoryServiceImpl> {

    public CategoryController(CategoryServiceImpl service) {
        super(service);
    }

    @Operation(summary = "Getting category")
    @GetMapping(value = PATH + "/category/list")
    public ResponseEntity<DataDTO<List<CategoryDTO>>> getAll( ) {
        return service.getAll();
    }

    @Operation(summary = "Getting user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully gotten",content = @Content(schema = @Schema(implementation = CategoryDTO.class))),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Category was not found",content = @Content)})
    @GetMapping(value = PATH + "/category/{id}")
    public ResponseEntity<DataDTO<CategoryDTO>> getById(@Parameter(description = "id of category to be gotten", required = true) @PathVariable Integer id) {
        return service.get(id);
    }

    @Operation(summary = "Deleting category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted",content = @Content),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Category was not found",content = @Content)})
    @GetMapping(value = PATH + "/category/delete/{id}")
    public ResponseEntity<DataDTO<Void>> delete(@Parameter(description = "id of category to be deleted", required = true) @PathVariable Integer id) {
        return service.delete(id);
    }

    @Operation(summary = "Creating category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully saved",content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Conflict was occurred related to",content = @Content)})
    @PostMapping(value = PATH + "/category/create")
    public ResponseEntity<DataDTO<Integer>> create(@RequestBody @Valid CategoryCreateDTO categoryCreateDto) {
        return service.create(categoryCreateDto);
    }

    @Operation(summary = "Updating category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated",content = @Content(schema = @Schema(implementation = CategoryDTO.class))),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Category was not found",content = @Content)})
    @RequestMapping(value = PATH + "/category/update", method = RequestMethod.PUT)
    public ResponseEntity<DataDTO<Void>> update(@RequestBody @Valid CategoryUpdateDTO categoryUpdateDto) {
        return service.update(categoryUpdateDto);
    }
}
