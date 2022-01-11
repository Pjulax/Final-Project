package pl.pp.store.raporting.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pp.store.raporting.model.Article;
import pl.pp.store.raporting.service.RaportService;

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


    @GetMapping(value = "/pdfraport",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> storeRaport() {

        ByteArrayInputStream bis = raportService.generateRaport();

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=articlesreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @GetMapping(value = "/pdfraport/all",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> allStoresRaport() {

        // TODO - change servise generateRaport to generateAllRaport
        ByteArrayInputStream bis = raportService.generateAllRaport();

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=articlesreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @GetMapping(value = "/pdfraport/article/{articleId}",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> articleRaport(@PathVariable(name = "articleId") Article articleId) {

        // TODO - change servise generateRaport to generateArticleRaport
        ByteArrayInputStream bis = raportService.generateArticleRaport();

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=articlesreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}
