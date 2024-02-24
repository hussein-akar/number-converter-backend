package com.project.numberconverterbackend.service.converters.toDecimal;

import com.project.numberconverterbackend.service.converters.NumberConverter;

public class FromBinaryNumberConverter implements NumberConverter<String, Long> {

    @Override
    public Long convert(String value) {
        return Long.parseLong(value, 2);
    }
}
