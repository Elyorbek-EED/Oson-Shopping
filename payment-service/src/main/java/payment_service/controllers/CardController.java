package payment_service.controllers;

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
import payment_service.criteria.CardCriteria;
import payment_service.dtos.CardCreateDTO;
import payment_service.dtos.CardDTO;
import payment_service.dtos.CardUpdateDTO;
import payment_service.service.CardServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@Tag(name = "Card Controller", description = "APIs for Card CRUD")
public class CardController extends AbstractController<CardServiceImpl> {

    public CardController(CardServiceImpl service) {
        super(service);
    }

    @Operation(summary = "Updating card")
    @RequestMapping(value = PATH + "/card/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<DataDTO<Void>> update(@RequestBody @Valid CardUpdateDTO authUserCartUpdateDto) {
        return service.update(authUserCartUpdateDto);
    }

    @Operation(summary = "Getting card")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully gotten",content = @Content(schema = @Schema(implementation = CardDTO.class))),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Card was not found",content = @Content)})
    @RequestMapping(value = PATH + "/card/{id}", method = RequestMethod.GET)
    public ResponseEntity<DataDTO<CardDTO>> getById(@Parameter(description = "id of card to be gotten",required = true)@PathVariable Integer id) {
        return service.get(id);
    }

    @Operation(summary = "Daleting card")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted",content = @Content),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Card was not found",content = @Content)})
    @RequestMapping(value = PATH + "/card/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DataDTO<Void>> delete(@Parameter(description = "id of card to be deleted",required = true) @PathVariable Integer id) {
        return service.delete(id);
    }

    @Operation(summary = "Createing card")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully saved",content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Conflict was occurred related to",content = @Content)})
    @RequestMapping(value = PATH + "/card/create", method = RequestMethod.POST)
    public ResponseEntity<DataDTO<Integer>> create(@RequestBody @Valid CardCreateDTO authUserCartCreateDto) {
        return service.create(authUserCartCreateDto);
    }

    @Operation(summary = "Getting cards")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully gotten",content = @Content(schema = @Schema(implementation = CardDTO.class))),
            @ApiResponse(responseCode = "403", description = "Permission was denied due to security",content = @Content),
            @ApiResponse(responseCode = "404", description = "Card was not found",content = @Content)})
    @RequestMapping(value = PATH + "/card/cards", method = RequestMethod.GET)
    public ResponseEntity<DataDTO<List<CardDTO>>> getCarts(@Valid CardCriteria criteria) {
        return service.getAll(criteria);
    }
}
