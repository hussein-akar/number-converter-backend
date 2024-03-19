package com.project.numberconverterbackend.service.toType;

public interface ToTypeNumberConverter {

    String convert(Long input);

    String supportedType();
}