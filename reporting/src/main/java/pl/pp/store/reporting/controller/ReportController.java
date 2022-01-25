package pl.pp.store.reporting.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pp.store.reporting.dto.StoreKeeperCredentialsDto;
import pl.pp.store.reporting.service.ReportService;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class ReportController {

    private final ReportService reportService;

    @GetMapping(value = "/store/my",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> storeReport(@RequestBody StoreKeeperCredentialsDto storeKeeperCredentialsDto) {

        ByteArrayInputStream bis = reportService.generateMyStoreStoredProductsReport(storeKeeperCredentialsDto);

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=articlesreport.pdf");
        log.info("I'm providing pdf!");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @GetMapping(value = "/store/all",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> allStoresReport(@RequestBody StoreKeeperCredentialsDto storeKeeperCredentialsDto) {

        // TODO - change servise generateReport to generateAllReport
        ByteArrayInputStream bis = reportService.generateAllReport(storeKeeperCredentialsDto);

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=articlesreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @GetMapping(value = "/product/{code}",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> articleReport(@PathVariable(name = "code") String code, @RequestBody StoreKeeperCredentialsDto storeKeeperCredentialsDto) {


        ByteArrayInputStream bis = reportService.generateProductReport(code, storeKeeperCredentialsDto);

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=articlesreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}
