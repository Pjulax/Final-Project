package pl.pp.store.ordersystem;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.kubernetes.fabric8.discovery.ConditionalOnKubernetesDiscoveryEnabled;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
@OpenAPIDefinition(info =
@Info(title = "Order system API", version = "1.0", description = "Documentation Order system API v1.0")
)
public class OrdersystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdersystemApplication.class, args);
    }

}
