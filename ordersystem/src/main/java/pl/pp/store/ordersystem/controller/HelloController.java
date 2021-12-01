package pl.pp.store.ordersystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pp.store.ordersystem.service.RaportService;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor
public class HelloController {

    private final RaportService raportService;

    @GetMapping
    public ResponseEntity hello(){
        return new ResponseEntity<String>("Hello World", HttpStatus.OK);
    }


    @GetMapping(value = "/pdfreport",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> citiesReport() {

        ByteArrayInputStream bis = raportService.generateReport();

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=articlesreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}
