package com.project.numberconverterbackend.factory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import com.project.numberconverterbackend.enums.NumberType;
import com.project.numberconverterbackend.exceptions.ConversionNotSupportedException;
import com.project.numberconverterbackend.service.converters.NumberConverter;
import com.project.numberconverterbackend.service.converters.fromDecimal.ToRomanNumberConverter;
import com.project.numberconverterbackend.service.converters.toDecimal.FromBinaryNumberConverter;
import com.project.numberconverterbackend.service.converters.toDecimal.FromDecimalStringNumberConverter;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NumberConverterFactoryTest {

    @Autowired
    private NumberConverterFactory underTest;

    @Nested
    class createFromTypeToDecimalConverter {

        @Test
        void shouldThrowExceptionWhenTypeIsNotSupported() {
            Throwable throwable = catchThrowable(() -> underTest.createFromTypeToDecimalConverter(NumberType.ROMAN));

            assertThat(throwable)
                .isInstanceOf(ConversionNotSupportedException.class)
                .hasMessage("Converting %s %s not supported at the moment!", "from", NumberType.ROMAN);
        }

        @Test
        void shouldReturnInstanceOfFromDecimalStringNumberConverterWhenTypeIsDecimal() {
            NumberConverter<?, ?> numberConverter = underTest.createFromTypeToDecimalConverter(NumberType.DECIMAL);

            assertThat(numberConverter).isInstanceOf(FromDecimalStringNumberConverter.class);
        }

        @Test
        void shouldReturnInstanceOfFromBinaryNumberConverterWhenTypeIsBinary() {
            NumberConverter<?, ?> numberConverter = underTest.createFromTypeToDecimalConverter(NumberType.BINARY);

            assertThat(numberConverter).isInstanceOf(FromBinaryNumberConverter.class);
        }
    }

    @Nested
    class createFromDecimalToTypeConverter {

        @Test
        void shouldThrowExceptionWhenTypeIsNotSupported() {
            Throwable throwable = catchThrowable(() -> underTest.createFromDecimalToTypeConverter(NumberType.DECIMAL));

            assertThat(throwable)
                .isInstanceOf(ConversionNotSupportedException.class)
                .hasMessage("Converting %s %s not supported at the moment!", "to", NumberType.DECIMAL);
        }

        @Test
        void shouldReturnInstanceOfFromDecimalStringNumberConverterWhenTypeIsDecimal() {
            NumberConverter<?, ?> numberConverter = underTest.createFromDecimalToTypeConverter(NumberType.ROMAN);

            assertThat(numberConverter).isInstanceOf(ToRomanNumberConverter.class);
        }
    }
}
