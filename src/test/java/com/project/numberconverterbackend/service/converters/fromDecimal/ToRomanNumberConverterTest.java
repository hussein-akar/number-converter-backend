package com.project.numberconverterbackend.service.converters.fromDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ToRomanNumberConverterTest {

    @InjectMocks
    private ToRomanNumberConverter underTest;

    @Test
    @SneakyThrows
    void shouldThrowExceptionWhenValueIsNull() {
        Throwable throwable = catchThrowable(() -> underTest.convert(null));

        assertThat(throwable).isInstanceOf(NumberFormatException.class);
    }

    @Test
    void shouldConvertToRomanRepresentationWhenDecimalInputIsValid() {
        String actual = underTest.convert(2531L);

        assertThat(actual).isEqualTo("MMDXXXI");
    }
}
