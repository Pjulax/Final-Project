package pl.pp.store.reporting.controller;

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
import pl.pp.store.reporting.model.Article;
import pl.pp.store.reporting.service.ReportService;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor
public class HelloController {

    private final ReportService reportService;

    @GetMapping
    public ResponseEntity hello(){
        return new ResponseEntity<String>("Hello World", HttpStatus.OK);
    }


    @GetMapping(value = "/pdfreport",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> storeReport() {

        ByteArrayInputStream bis = reportService.generateReport();

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=articlesreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @GetMapping(value = "/pdfreport/all",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> allStoresReport() {

        // TODO - change servise generateReport to generateAllReport
        ByteArrayInputStream bis = reportService.generateAllReport();

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=articlesreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @GetMapping(value = "/pdfreport/article/{articleId}",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> articleReport(@PathVariable(name = "articleId") Long articleId) {

        // TODO - change servise generateReport to generateArticleReport
        ByteArrayInputStream bis = reportService.generateArticleReport();

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=articlesreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}
