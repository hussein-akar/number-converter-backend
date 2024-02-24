package com.project.numberconverterbackend.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.project.numberconverterbackend.enums.NumberType;
import com.project.numberconverterbackend.service.NumberConverterService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@WebMvcTest(NumberConverterController.class)
class NumberConverterControllerTest {

    public static final String URL = "/api/number-converters";

    @MockBean
    NumberConverterService numberConverterService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @SneakyThrows
    void shouldThrowBadRequestExceptionWhenFromTypeIsNull() {
        this.mockMvc.perform(post(URL.concat("/convert"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    """
                            {
                                "toType": "ROMAN",
                                "value": "4"
                            }
                        """
                ))
            .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    void shouldThrowBadRequestExceptionWhenToTypeIsNull() {
        this.mockMvc.perform(post(URL.concat("/convert"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    """
                            {
                               "FromType": "DECIMAL",
                                "value": "4"
                            }
                        """
                ))
            .andExpect(status().isBadRequest());
    }

    @NullSource
    @ValueSource(strings = {""})
    @ParameterizedTest
    @SneakyThrows
    void shouldThrowBadRequestExceptionWhenValueIsBlank(String value) {
        this.mockMvc.perform(post(URL.concat("/convert"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    String.format(
                        """
                            {
                                "fromType": "DECIMAL",
                                "toType": "ROMAN",
                                "value": %s
                            }
                            """, value)
                ))
            .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    void shouldRespondWithOkayAndIVWhenConvertingDecimalNumberFourToRoman() {
        when(numberConverterService.convert(NumberType.DECIMAL, NumberType.ROMAN, "4"))
            .thenReturn("IV");

        MvcResult mvcResult = this.mockMvc.perform(post(URL.concat("/convert"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    """
                            {
                                "fromType": "DECIMAL",
                                "toType": "ROMAN",
                                "value": "4"
                            }
                        """
                ))
            .andExpect(status().isOk())
            .andReturn();

        String expected = "IV";
        assertThat(mvcResult.getResponse().getContentAsString()).isEqualTo(expected);
    }
}
