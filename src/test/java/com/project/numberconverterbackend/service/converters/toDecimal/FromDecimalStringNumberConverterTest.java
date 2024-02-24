package com.project.numberconverterbackend.service.converters.toDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FromDecimalStringNumberConverterTest {

    @InjectMocks
    private FromDecimalStringNumberConverter underTest;

    @NullSource
    @ValueSource(strings = {"", "ABC"})
    @ParameterizedTest
    @SneakyThrows
    void shouldThrowExceptionWhenValueIsNotValid(String value) {
        Throwable throwable = catchThrowable(() -> underTest.convert(value));

        assertThat(throwable).isInstanceOf(NumberFormatException.class);
    }

    @Test
    void shouldConvertToProperDecimalWhenInputIsValid() {
        Long actual = underTest.convert("12847");

        assertThat(actual).isEqualTo(12847);
    }
}
