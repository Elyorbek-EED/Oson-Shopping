package billing_service.controllers;

import billing_service.criteria.AddressCriteria;
import billing_service.dtos.address.AddressCreateDTO;
import billing_service.dtos.address.AddressDTO;
import billing_service.dtos.address.AddressUpdateDTO;
import billing_service.entity.address.Address;
import billing_service.service.AddressServiceImpl;
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

import javax.validation.Valid;
import java.util.List;

@RestController
@Tag(name = "Address Controller", description = "APIs for Address CRUD")
public class AddressController extends AbstractController<AddressServiceImpl> {

    public AddressController(AddressServiceImpl service){
        super(service);
    }

    @Operation(summary = "Updating address")
    @RequestMapping(value = PATH + "/address/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<DataDTO<Void>> update(@RequestBody @Valid AddressUpdateDTO authUserCartUpdateDto) {
        return service.update(authUserCartUpdateDto);
    }

    @Operation(summary = "Getting address")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully gotten",content = @Content(schema = @Schema(implementation = AddressDTO.class))),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Address was not found",content = @Content)})
    @RequestMapping(value = PATH + "/address/{id}", method = RequestMethod.GET)
    public ResponseEntity<DataDTO<AddressDTO>> getById(@Parameter(description = "id of address to be gotten",required = true)@PathVariable Integer id) {
        return service.get(id);
    }

    @Operation(summary = "Daleting address")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted",content = @Content),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Address was not found",content = @Content)})
    @RequestMapping(value = PATH + "/address/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DataDTO<Void>> delete(@Parameter(description = "id of address to be deleted",required = true) @PathVariable Integer id) {
        return service.delete(id);
    }

    @Operation(summary = "Createing address")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully saved",content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Conflict was occurred related to",content = @Content)})
    @RequestMapping(value = PATH + "/address/create", method = RequestMethod.POST)
    public ResponseEntity<DataDTO<Integer>> create(@RequestBody @Valid AddressCreateDTO authUserCartCreateDto) {
        return service.create(authUserCartCreateDto);
    }

    @Operation(summary = "Getting addresss")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully gotten",content = @Content(schema = @Schema(implementation = AddressDTO.class))),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Address was not found",content = @Content)})
    @RequestMapping(value = PATH + "/address/addresss", method = RequestMethod.GET)
    public ResponseEntity<DataDTO<List<AddressDTO>>> getCarts(@Valid AddressCriteria criteria) {
        return service.getAll(criteria);
    }
}
