package com.project.numberconverterbackend.payload;

import com.project.numberconverterbackend.enums.NumberType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class NumberConverterPayload {

    @NotNull
    private NumberType fromType;

    @NotNull
    private NumberType toType;

    @NotBlank
    private String value;
}
