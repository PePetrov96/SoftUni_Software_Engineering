package com.example.jsonprocessing.config;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import java.util.List;

public class GsonBuilderWrapper {
    private final List<String> excludedFields;

    public GsonBuilderWrapper(List<String> excludedFields) {
        this.excludedFields = excludedFields;
    }

    public Gson createGson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getAnnotation(Expose.class) != null && excludedFields.contains(f.getName());
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .setPrettyPrinting()
                .create();
    }
}
