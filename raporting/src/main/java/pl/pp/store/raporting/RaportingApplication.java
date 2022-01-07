package pl.pp.store.raporting;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info =
@Info(title = "Raporting API", version = "1.0", description = "Documentation Raporting API v1.0")
)
public class RaportingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RaportingApplication.class, args);
    }

}
