package com.project.numberconverterbackend.service;

import com.project.numberconverterbackend.enums.NumberType;

public interface NumberConverterService {

    String convert(NumberType fromType, NumberType toType, String value);
}
