package com.project.numberconverterbackend.factory;

import com.project.numberconverterbackend.enums.NumberType;
import com.project.numberconverterbackend.exceptions.ConversionNotSupportedException;
import com.project.numberconverterbackend.service.converters.NumberConverter;
import com.project.numberconverterbackend.service.converters.fromDecimal.ToRomanNumberConverter;
import com.project.numberconverterbackend.service.converters.toDecimal.FromBinaryNumberConverter;
import com.project.numberconverterbackend.service.converters.toDecimal.FromDecimalStringNumberConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NumberConverterFactory {

    public NumberConverter<String, Long> createFromTypeToDecimalConverter(NumberType type) {
        switch (type) {
            case DECIMAL -> {
                return new FromDecimalStringNumberConverter();
            }
            case BINARY -> {
                return new FromBinaryNumberConverter();
            }
            default -> throw new ConversionNotSupportedException(type, true);
        }
    }

    public NumberConverter<Long, String> createFromDecimalToTypeConverter(NumberType type) {
        switch (type) {
            case ROMAN -> {
                return new ToRomanNumberConverter();
            }
            default -> throw new ConversionNotSupportedException(type, false);
        }
    }
}
