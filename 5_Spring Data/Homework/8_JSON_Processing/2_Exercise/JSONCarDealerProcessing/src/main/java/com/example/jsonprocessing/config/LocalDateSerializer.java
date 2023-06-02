package com.example.jsonprocessing.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateSerializer implements JsonSerializer<LocalDate> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;

    @Override
    public JsonElement serialize(LocalDate localDate, Type type, JsonSerializationContext jsonSerializationContext) {
        String formattedDate = localDate.format(formatter);
        return new JsonPrimitive(formattedDate);
    }
}