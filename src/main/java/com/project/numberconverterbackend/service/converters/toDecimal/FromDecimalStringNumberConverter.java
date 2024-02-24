package com.project.numberconverterbackend.service.converters.toDecimal;

import com.project.numberconverterbackend.service.converters.NumberConverter;
import org.springframework.stereotype.Service;

@Service
public class FromDecimalStringNumberConverter implements NumberConverter<String, Long> {

    @Override
    public Long convert(String value) {
        return Long.valueOf(value);
    }
}
