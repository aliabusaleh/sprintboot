package com.exalt.sprintboot.service;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

import java.util.Date;

public class LongToDateConverter implements Converter<Long, Date> {
    @Override
    public Date convert(Long lng) {
        if(lng!=null)
            return new Date(lng);
        else
            return null;
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return null;
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return null;
    }

}