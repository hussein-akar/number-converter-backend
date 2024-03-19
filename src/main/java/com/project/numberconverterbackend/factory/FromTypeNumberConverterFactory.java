package com.project.numberconverterbackend.factory;

import com.project.numberconverterbackend.exceptions.FromTypeConversionNotSupportedException;
import com.project.numberconverterbackend.service.fromType.FromTypeNumberConverter;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class FromTypeNumberConverterFactory {

    private final Map<String, FromTypeNumberConverter> converterMap;

    public FromTypeNumberConverterFactory(List<FromTypeNumberConverter> converters) {
        this.converterMap = converters.stream().collect(Collectors.toMap(FromTypeNumberConverter::supportedType, Function.identity()));
    }

    public FromTypeNumberConverter create(String type) {
        if (!converterMap.containsKey(type)) {
            throw new FromTypeConversionNotSupportedException(type);
        }

        return converterMap.get(type);
    }
}
