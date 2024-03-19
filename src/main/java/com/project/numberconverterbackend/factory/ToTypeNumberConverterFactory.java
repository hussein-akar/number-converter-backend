package com.project.numberconverterbackend.factory;

import com.project.numberconverterbackend.exceptions.ToTypeConversionNotSupportedException;
import com.project.numberconverterbackend.service.toType.ToTypeNumberConverter;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ToTypeNumberConverterFactory {

    private final Map<String, ToTypeNumberConverter> converterMap;

    public ToTypeNumberConverterFactory(List<ToTypeNumberConverter> converters) {
        this.converterMap = converters.stream().collect(Collectors.toMap(ToTypeNumberConverter::supportedType, Function.identity()));
    }

    public ToTypeNumberConverter create(String type) {
        if (!converterMap.containsKey(type)) {
            throw new ToTypeConversionNotSupportedException(type);
        }

        return converterMap.get(type);
    }
}
