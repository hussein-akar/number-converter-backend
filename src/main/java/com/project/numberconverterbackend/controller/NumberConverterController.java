package com.project.numberconverterbackend.controller;

import com.project.numberconverterbackend.payload.NumberConverterPayload;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/number-converters")
public class NumberConverterController {

    @PostMapping("/convert")
    public ResponseEntity<String> convert(@RequestBody @Valid NumberConverterPayload payload) {
        String result = "IV";
        return ResponseEntity.ok(result);
    }
}
