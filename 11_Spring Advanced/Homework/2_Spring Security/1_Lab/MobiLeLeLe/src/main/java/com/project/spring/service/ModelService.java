package com.project.spring.service;

import com.project.spring.models.entity.Model;

import java.util.List;

public interface ModelService {
    void importModels();
    String readModelFileContent();
    boolean hasInitialized();
    List<Model> listAll();
}
