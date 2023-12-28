package springdatalab.service;

import springdatalab.models.entities.Category;

public interface CategoryService {

    void addCategory(String name);

    Category findByName(String name);
}
