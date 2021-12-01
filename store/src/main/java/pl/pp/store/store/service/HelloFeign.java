package pl.pp.store.store.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("ordersystem-service")
public interface HelloFeign {

    @GetMapping("/hello")
    ResponseEntity<String> getHello();

}
