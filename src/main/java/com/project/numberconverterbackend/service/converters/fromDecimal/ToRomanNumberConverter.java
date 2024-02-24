package com.project.numberconverterbackend.service.converters.fromDecimal;

import com.project.numberconverterbackend.service.converters.NumberConverter;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class ToRomanNumberConverter implements NumberConverter<Long, String> {

    private static final Map<Integer, String> romanNumeralByDecimalMap = new LinkedHashMap<>();

    public ToRomanNumberConverter() {
        romanNumeralByDecimalMap.put(1000, "M");
        romanNumeralByDecimalMap.put(900, "CM");
        romanNumeralByDecimalMap.put(500, "D");
        romanNumeralByDecimalMap.put(400, "CD");
        romanNumeralByDecimalMap.put(100, "C");
        romanNumeralByDecimalMap.put(90, "XC");
        romanNumeralByDecimalMap.put(50, "L");
        romanNumeralByDecimalMap.put(40, "XL");
        romanNumeralByDecimalMap.put(10, "X");
        romanNumeralByDecimalMap.put(9, "IX");
        romanNumeralByDecimalMap.put(5, "V");
        romanNumeralByDecimalMap.put(4, "IV");
        romanNumeralByDecimalMap.put(1, "I");
    }

    @Override
    public String convert(Long value) {
        if(value == null) {
            throw new NumberFormatException();
        }

        StringBuilder roman = new StringBuilder();

        for (Map.Entry<Integer, String> entry : romanNumeralByDecimalMap.entrySet()) {
            int entryKey = entry.getKey();
            String symbol = entry.getValue();
            while (value >= entryKey) {
                roman.append(symbol);
                value -= entryKey;
            }
        }

        return roman.toString();
    }
}
