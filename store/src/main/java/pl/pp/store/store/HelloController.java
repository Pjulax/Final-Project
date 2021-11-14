package pl.pp.store.store;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor
public class HelloController {

    private final HelloFeignImpl helloFeign;

    @GetMapping
    public ResponseEntity hello(){
        ResponseEntity<String> response = helloFeign.getHelloRequest();
        return new ResponseEntity<String>(response.getBody(), response.getStatusCode());
    }
}
