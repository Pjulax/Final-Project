package pl.pp.store.store.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class HelloFeignImpl{

    private final HelloFeign helloFeign;

    public ResponseEntity<String> getHelloRequest() {
        ResponseEntity<String> response = helloFeign.getHello();
        log.info("Request sent\nBody is: {}\nStatus code is: {}", response.getBody(), response.getStatusCode());
        return response;
    }
}
