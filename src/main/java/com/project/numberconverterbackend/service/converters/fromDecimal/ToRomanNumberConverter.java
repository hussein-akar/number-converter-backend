package com.project.numberconverterbackend.service.converters.fromDecimal;

import com.project.numberconverterbackend.service.converters.NumberConverter;
import org.springframework.stereotype.Component;

@Component
public class ToRomanNumberConverter implements NumberConverter<Long, String> {

    @Override
    public String convert(Long value) {
        return null;
    }
}
