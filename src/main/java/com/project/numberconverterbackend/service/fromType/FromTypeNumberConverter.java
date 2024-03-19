package com.project.numberconverterbackend.service.fromType;

public interface FromTypeNumberConverter {

    Long convert(String input);

    String supportedType();
}
