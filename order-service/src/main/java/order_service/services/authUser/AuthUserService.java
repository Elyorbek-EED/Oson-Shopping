package order_service.services.authUser;

import online_shop_jar.response.DataDTO;
import order_service.dtos.AuthUserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("account-service")
@Service
public interface AuthUserService {

    @GetMapping(name = "/user/get/{id}")
    ResponseEntity<DataDTO<AuthUserDTO>> getAUthUser(@RequestParam("id") Integer id);
}
