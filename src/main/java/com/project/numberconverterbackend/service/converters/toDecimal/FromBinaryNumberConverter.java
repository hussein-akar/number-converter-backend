package com.project.numberconverterbackend.service.converters.toDecimal;

import com.project.numberconverterbackend.service.converters.NumberConverter;
import org.springframework.stereotype.Component;

@Component
public class FromBinaryNumberConverter implements NumberConverter<String, Long> {

    @Override
    public Long convert(String value) {
        return null;
    }
}
