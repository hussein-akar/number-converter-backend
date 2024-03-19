package com.project.numberconverterbackend.exceptions;

public class ToTypeConversionNotSupportedException extends RuntimeException {

    public ToTypeConversionNotSupportedException(String type) {
        super("Converting to %s not supported at the moment!".formatted(type));
    }
}
