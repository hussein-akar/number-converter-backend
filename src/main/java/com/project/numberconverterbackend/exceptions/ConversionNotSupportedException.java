package com.project.numberconverterbackend.exceptions;

import com.project.numberconverterbackend.enums.NumberType;

public class ConversionNotSupportedException extends RuntimeException {

    public ConversionNotSupportedException(NumberType type, boolean isConvertingFrom) {
        super("Converting %s %s not supported at the moment!"
            .formatted(isConvertingFrom ? "from" : "to", type.name()));
    }
}
