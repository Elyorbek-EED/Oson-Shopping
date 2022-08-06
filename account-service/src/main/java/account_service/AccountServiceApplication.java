package account_service;

import account_service.entity.authUser.AuthUser;
import account_service.enums.Gender;
import account_service.enums.Language;
import account_service.enums.Role;
import account_service.enums.Status;
import account_service.repository.authUser.AuthUserRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition
@RequiredArgsConstructor
@EnableEurekaClient
public class AccountServiceApplication {

    private final AuthUserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
//                @Bean
    CommandLineRunner runner() {
        return (args) -> {

            AuthUser admin = AuthUser.builder()
                    .userName("qwerty")
                    .password("7722")
                    .role(Role.SUPER_ADMIN)
                    .fullName("super super")
                    .gender(Gender.MALE)
                    .phone("+998901111111")
                    .email("mr.eed7420@gmailcom")
                    .language(Language.ENGLISH)
                    .fullName("Qwerty qwerty")
                    .status(Status.ACTIVE)
                    .build();
            repository.save(admin);
        };
    }


}
