package com.project.numberconverterbackend.service.converters.toDecimal;

import com.project.numberconverterbackend.service.converters.NumberConverter;

public class FromDecimalStringNumberConverter implements NumberConverter<String, Long> {

    @Override
    public Long convert(String value) {
        return Long.valueOf(value);
    }
}
