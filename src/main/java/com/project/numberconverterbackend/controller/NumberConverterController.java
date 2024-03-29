package com.project.numberconverterbackend.controller;

import com.project.numberconverterbackend.payload.NumberConverterPayload;
import com.project.numberconverterbackend.response.NumberConversionResponse;
import com.project.numberconverterbackend.service.NumberConverterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/number-converters")
public class NumberConverterController {

    private final NumberConverterService numberConverterService;

    @PostMapping("/convert")
    public ResponseEntity<NumberConversionResponse> convert(@RequestBody @Valid NumberConverterPayload payload) {
        String result = numberConverterService.convert(payload.getFromType(), payload.getToType(), payload.getValue());
        return ResponseEntity.ok(new NumberConversionResponse(result));
    }
}
