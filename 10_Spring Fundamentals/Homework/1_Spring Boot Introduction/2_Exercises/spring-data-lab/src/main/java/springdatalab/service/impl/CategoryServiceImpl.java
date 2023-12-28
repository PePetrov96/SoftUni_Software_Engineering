package springdatalab.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdatalab.models.entities.Category;
import springdatalab.models.service.CategoryServiceModel;
import springdatalab.repositories.CategoryRepository;
import springdatalab.service.CategoryService;
import springdatalab.util.ValidationUtil;

import javax.validation.ConstraintViolation;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addCategory(String name) {

        CategoryServiceModel categoryServiceModel = new CategoryServiceModel();
        categoryServiceModel.setName(name);

        if (!this.validationUtil.isValid(categoryServiceModel)) {
            this.validationUtil
                    .violations(categoryServiceModel)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

        } else {
            try {
                this.categoryRepository
                        .saveAndFlush(this.modelMapper.map(categoryServiceModel, Category.class));
            } catch (Exception e) {
                System.out.println("Some thing went wrong!");
            }
        }
    }

    @Override
    public Category findByName(String name) {

        return  this.categoryRepository.findByName(name);
    }


}
