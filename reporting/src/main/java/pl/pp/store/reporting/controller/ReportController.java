package pl.pp.store.reporting.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pp.store.reporting.dto.StoreKeeperCredentialsDto;
import pl.pp.store.reporting.service.ReportService;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class ReportController {

    private final ReportService reportService;

    @Operation(summary = "Get my store PDF report")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully produced PDF."),
            @ApiResponse(responseCode = "400", description = "Something went wrong."),
            @ApiResponse(responseCode = "403", description = "Not found store and user to authorize. Access forbidden.")
    })
    @GetMapping(value = "/store/my",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> getStoreReport(@ParameterObject StoreKeeperCredentialsDto storeKeeperCredentialsDto) {

        ByteArrayInputStream bis = reportService.generateMyStoreStoredProductsReport(storeKeeperCredentialsDto);

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=Store_report.pdf");
        log.info("I'm providing pdf!");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @Operation(summary = "Get my store PDF report")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully produced PDF."),
            @ApiResponse(responseCode = "400", description = "Something went wrong."),
            @ApiResponse(responseCode = "403", description = "Not found store and user to authorize. Access forbidden.")
    })
    @GetMapping(value = "/store/all",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> getAllStoresReport(@ParameterObject StoreKeeperCredentialsDto storeKeeperCredentialsDto) {

        ByteArrayInputStream bis = reportService.generateAllReport(storeKeeperCredentialsDto);

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=All_Stores_report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @Operation(summary = "Get one product from all stores PDF report")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully produced PDF."),
            @ApiResponse(responseCode = "400", description = "Something went wrong."),
            @ApiResponse(responseCode = "403", description = "Not found store and user to authorize. Access forbidden.")
    })
    @GetMapping(value = "/product/{code}",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> getProductFromAllStoresReport(@PathVariable(name = "code") String code, @ParameterObject StoreKeeperCredentialsDto storeKeeperCredentialsDto) {

        ByteArrayInputStream bis = reportService.generateProductReport(code, storeKeeperCredentialsDto);

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=Product_All_Stores_report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}
