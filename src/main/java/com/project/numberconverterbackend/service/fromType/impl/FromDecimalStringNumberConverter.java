package com.project.numberconverterbackend.service.fromType.impl;

import com.project.numberconverterbackend.service.fromType.FromTypeNumberConverter;
import org.springframework.stereotype.Service;

@Service
public class FromDecimalStringNumberConverter implements FromTypeNumberConverter {

    @Override
    public Long convert(String value) {
        return Long.valueOf(value);
    }

    @Override
    public String supportedType() {
        return "DECIMAL";
    }
}
