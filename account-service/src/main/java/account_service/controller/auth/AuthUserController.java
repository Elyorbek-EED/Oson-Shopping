package account_service.controller.auth;


import account_service.criteria.authUser.AuthUserCriteria;
import account_service.dtos.auth.AuthUserCreateDTO;
import account_service.dtos.auth.AuthUserDTO;
import account_service.dtos.auth.AuthUserUpdateDTO;
import account_service.service.authUser.AuthUserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import online_shop_jar.controller.AbstractController;
import online_shop_jar.response.DataDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@Tag(name = "User Controller", description = "APIs for user CRUD")
public class AuthUserController extends AbstractController<AuthUserServiceImpl> {

    public AuthUserController(AuthUserServiceImpl service) {
        super(service);
    }

    @Operation(summary = "Getting user")
    @GetMapping(value = PATH + "/user/get/{id}")
    public ResponseEntity<DataDTO<AuthUserDTO>> get(@Parameter(description = "id of user to be gotten", required = true) @PathVariable Integer id) {
        return service.get(id);
    }

    @Operation(summary = "Creating user")
    @PostMapping(value = PATH + "/user/create")
    public ResponseEntity<DataDTO<Integer>> create(@RequestBody @Valid AuthUserCreateDTO dto) {
        return service.create(dto);
    }


    @Operation(summary = "Deleting user")

    @DeleteMapping(value = PATH + "/user/delete/{id}")
    public ResponseEntity<DataDTO<Void>> delete(@Parameter(description = "id of admin to be deleted", required = true) @PathVariable Integer id) {
        return service.delete(id);
    }


    @Operation(summary = "Updating user")
    @PutMapping(value = PATH + "/user/update")
    public ResponseEntity<DataDTO<Void>> update(@RequestBody @Valid AuthUserUpdateDTO dto) {
        return service.update(dto);
    }

    @Operation(summary = "Getting users")
    @PutMapping(value = PATH + "/user/users/getAll")
    public ResponseEntity<DataDTO<List<AuthUserDTO>>> getAll(AuthUserCriteria criteria) {
        return service.getAll(criteria);
    }
}
