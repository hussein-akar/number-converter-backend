package com.project.numberconverterbackend.exceptions;

public class FromTypeConversionNotSupportedException extends RuntimeException {

    public FromTypeConversionNotSupportedException(String type) {
        super("Converting from %s not supported at the moment!".formatted(type));
    }
}
