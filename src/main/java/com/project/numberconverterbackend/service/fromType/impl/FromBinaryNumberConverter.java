package com.project.numberconverterbackend.service.fromType.impl;

import com.project.numberconverterbackend.service.fromType.FromTypeNumberConverter;
import org.springframework.stereotype.Service;

@Service
public class FromBinaryNumberConverter implements FromTypeNumberConverter {

    @Override
    public Long convert(String value) {
        return Long.parseLong(value, 2);
    }

    @Override
    public String supportedType() {
        return "BINARY";
    }
}
