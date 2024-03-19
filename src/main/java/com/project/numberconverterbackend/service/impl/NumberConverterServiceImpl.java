package com.project.numberconverterbackend.service.impl;

import com.project.numberconverterbackend.factory.FromTypeNumberConverterFactory;
import com.project.numberconverterbackend.factory.ToTypeNumberConverterFactory;
import com.project.numberconverterbackend.service.NumberConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NumberConverterServiceImpl implements NumberConverterService {

    private final FromTypeNumberConverterFactory fromTypeNumberConverterFactory;
    private final ToTypeNumberConverterFactory toTypeNumberConverterFactory;

    @Override
    public String convert(String fromType, String toType, String value) {
        Long decimalValue = fromTypeNumberConverterFactory.create(fromType).convert(value);
        return toTypeNumberConverterFactory.create(toType).convert(decimalValue);
    }
}