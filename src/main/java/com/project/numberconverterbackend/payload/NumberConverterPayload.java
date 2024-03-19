package com.project.numberconverterbackend.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class NumberConverterPayload {

    @NotNull
    private String fromType;

    @NotNull
    private String toType;

    @NotBlank
    private String value;
}
