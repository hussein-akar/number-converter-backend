package com.project.numberconverterbackend.service.impl;

import com.project.numberconverterbackend.enums.NumberType;
import com.project.numberconverterbackend.service.NumberConverterService;
import org.springframework.stereotype.Service;

@Service
public class NumberConverterServiceImpl implements NumberConverterService {

    @Override
    public String convert(NumberType fromType, NumberType toType, String value) {
        return "IV";
    }
}
