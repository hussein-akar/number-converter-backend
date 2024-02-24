package com.project.numberconverterbackend.factory;

import com.project.numberconverterbackend.enums.NumberType;
import com.project.numberconverterbackend.exceptions.ConversionNotSupportedException;
import com.project.numberconverterbackend.service.converters.NumberConverter;
import com.project.numberconverterbackend.service.converters.fromDecimal.ToRomanNumberConverter;
import com.project.numberconverterbackend.service.converters.toDecimal.FromBinaryNumberConverter;
import com.project.numberconverterbackend.service.converters.toDecimal.FromDecimalStringNumberConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NumberConverterFactory {

    private final ApplicationContext applicationContext;

    public NumberConverter<String, Long> createFromTypeToDecimalConverter(NumberType type) {
        switch (type) {
            case DECIMAL -> {
                return applicationContext.getBean(FromDecimalStringNumberConverter.class);
            }
            case BINARY -> {
                return applicationContext.getBean(FromBinaryNumberConverter.class);
            }
            default -> throw new ConversionNotSupportedException(type, true);
        }
    }

    public NumberConverter<Long, String> createFromDecimalToTypeConverter(NumberType type) {
        switch (type) {
            case ROMAN -> {
                return applicationContext.getBean(ToRomanNumberConverter.class);
            }
            default -> throw new ConversionNotSupportedException(type, false);
        }
    }
}
