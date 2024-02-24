package com.project.numberconverterbackend.service.impl;

import static org.mockito.Mockito.when;

import com.project.numberconverterbackend.enums.NumberType;
import com.project.numberconverterbackend.factory.NumberConverterFactory;
import com.project.numberconverterbackend.service.converters.fromDecimal.ToRomanNumberConverter;
import com.project.numberconverterbackend.service.converters.toDecimal.FromBinaryNumberConverter;
import com.project.numberconverterbackend.service.converters.toDecimal.FromDecimalStringNumberConverter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NumberConverterServiceImplTest {

    @Mock
    private NumberConverterFactory numberConverterFactory;

    @InjectMocks
    private NumberConverterServiceImpl underTest;

    @Test
    void shouldReturnRomanRepresentationWhenConvertingFromDecimal() {
        when(numberConverterFactory.createFromTypeToDecimalConverter(NumberType.DECIMAL)).thenReturn(new FromDecimalStringNumberConverter());
        when(numberConverterFactory.createFromDecimalToTypeConverter(NumberType.ROMAN)).thenReturn(new ToRomanNumberConverter());

        String actual = underTest.convert(NumberType.DECIMAL, NumberType.ROMAN, "1017");

        Assertions.assertThat(actual).isEqualTo("MXVII");
    }

    @Test
    void shouldReturnRomanRepresentationWhenConvertingFromBinary() {
        when(numberConverterFactory.createFromTypeToDecimalConverter(NumberType.BINARY)).thenReturn(new FromBinaryNumberConverter());
        when(numberConverterFactory.createFromDecimalToTypeConverter(NumberType.ROMAN)).thenReturn(new ToRomanNumberConverter());

        String actual = underTest.convert(NumberType.BINARY, NumberType.ROMAN, "1110101010");

        Assertions.assertThat(actual).isEqualTo("CMXXXVIII");
    }
}
