package ru.neoflex.calculateapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.calculateapp.service.CalculateService;
import ru.neoflex.calculateapp.service.impl.CalculateServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
public class CalculateController {

    private final CalculateService calculateService;

    public CalculateController(CalculateServiceImpl calculateService) {
        this.calculateService = calculateService;
    }

    @Operation(
            summary = "Vocation pay endpoint",
            description = "Receiving the calculation of vacation pay")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Sum vocation pay",
                            content = @Content),
                    @ApiResponse(
                            responseCode = "400",
                            description = "No correct range date or sum",
                            content = @Content)
            })
    @GetMapping("/calculate")
    public ResponseEntity<BigDecimal> calculateVocationPay(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy")
                                                           LocalDate startDate,
                                                           @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy")
                                                           LocalDate endDate,
                                                           @RequestParam BigDecimal sum) {
        return ResponseEntity.ok(calculateService.calculateVocationPay(startDate, endDate, sum));
    }
}
