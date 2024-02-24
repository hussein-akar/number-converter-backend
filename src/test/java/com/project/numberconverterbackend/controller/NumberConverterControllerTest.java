package com.project.numberconverterbackend.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@WebMvcTest
class NumberConverterControllerTest {

    public static final String URL = "/api/number-converters";

    @Autowired
    private MockMvc mockMvc;

    @Test
    @SneakyThrows
    void shouldRespondWithOkayAndIVWhenConvertingDecimalNumberFourToRoman() {
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
