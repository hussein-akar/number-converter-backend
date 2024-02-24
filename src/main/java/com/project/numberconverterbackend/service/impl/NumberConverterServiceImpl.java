package com.project.numberconverterbackend.service.impl;

import com.project.numberconverterbackend.enums.NumberType;
import com.project.numberconverterbackend.factory.NumberConverterFactory;
import com.project.numberconverterbackend.service.NumberConverterService;
import com.project.numberconverterbackend.service.converters.NumberConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NumberConverterServiceImpl implements NumberConverterService {

    private final NumberConverterFactory numberConverterFactory;

    @Override
    public String convert(NumberType fromType, NumberType toType, String value) {
        NumberConverter<String, Long> fromTypeToDecimalConverter = numberConverterFactory.createFromTypeToDecimalConverter(fromType);
        NumberConverter<Long, String> fromDecimalToTypeConverter = numberConverterFactory.createFromDecimalToTypeConverter(toType);

        Long decimalValue = fromTypeToDecimalConverter.convert(value);
        return fromDecimalToTypeConverter.convert(decimalValue);
    }
}
