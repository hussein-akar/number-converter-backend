package com.project.numberconverterbackend.service.converters;

public interface NumberConverter<T, R> {

    R convert(T value);
}
