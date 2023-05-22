package com.example.advquerying;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Label;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.IngredientsRepository;
import com.example.advquerying.repositories.LabelRepository;
import com.example.advquerying.repositories.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final ShampooRepository shampooRepository;
    private final IngredientsRepository ingredientsRepository;
    private final LabelRepository labelRepository;
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Autowired
    public ConsoleRunner(ShampooRepository shampooRepository, IngredientsRepository ingredientsRepository, LabelRepository labelRepository) {
        this.shampooRepository = shampooRepository;
        this.ingredientsRepository = ingredientsRepository;
        this.labelRepository = labelRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        task_1(); //Example input: Medium

        task_2(); //Example input: Medium
                  //Example input: 10

        task_3(); //Example input: 5

        task_4(); //Example input: M

        task_5(); //Example input: Lavender, Herbs, Apple

        task_6(); //Example input: 8.50

        task_7(); //Example input: Berry, Mineral-Collagen

        task_8(); //Example input: 2

        task_9(); //Example input: Berry

        task_10(); //Example input:

        task_11(); //Example input: Lavender, Herbs, Apple
    }

    private void task_1() throws IOException {
        System.out.print("Select shampoo by size (SMALL, MEDIUM, LARGE): ");

        String input = this.reader.readLine();

        Size size = Size.valueOf(input.toUpperCase());

        List<Shampoo> shampooList = shampooRepository.getAllBySizeOrderById(size);

        for (Shampoo shampoo : shampooList) {
            System.out.printf("%s %s %.2flv.%n", shampoo.getBrand(), shampoo.getSize().toString(), shampoo.getPrice());
        }
    }
    private void task_2() throws IOException {
        System.out.println("Select shampoo by size or label.");

        System.out.print("Size (SMALL, MEDIUM, LARGE): ");
        String sizeValue = reader.readLine();

        Size size = Size.valueOf(sizeValue.toUpperCase());

        System.out.print("Label: ");
        Long labelId = Long.parseLong(reader.readLine());

        Label label = this.labelRepository
                .findById(labelId)
                .orElse(null);


        List<Shampoo> shampooList = this.shampooRepository
                .getAllBySizeOrLabelOrderByPrice(size, label);

        for (Shampoo shampoo : shampooList) {
            System.out.printf("%s %s %.2flv.%n", shampoo.getBrand(), shampoo.getSize().toString(), shampoo.getPrice());
        }
    }
    private void task_3() throws IOException {
        System.out.print("Select shampoo by price: ");
        String input = reader.readLine();

        BigDecimal priceValue = new BigDecimal(input);

        List<Shampoo> shampooList = this.shampooRepository
                .getAllByPriceGreaterThanOrderByPriceDesc(priceValue);

        for (Shampoo shampoo : shampooList) {
            System.out.printf("%s %s %.2flv.%n", shampoo.getBrand(), shampoo.getSize().toString(), shampoo.getPrice());
        }
    }
    private void task_4() throws IOException {
        System.out.print("Select ingredients by name, starting with: ");

        String input = reader.readLine();

        List<Ingredient> ingredients = this.ingredientsRepository.findAllByNameStartingWith(input);

        for (Ingredient ingredient : ingredients) {
            System.out.println(ingredient.getName());
        }
    }
    private void task_5() throws IOException {
        System.out.print("Select ingredients by names, separated by comma and space (\", \"): ");

        List<String> input = Arrays.stream(reader.readLine().split(",\\s+")).toList();

        List<Ingredient> ingredients = this.ingredientsRepository.findAllByNameIsInOrderByPrice(input);

        for (Ingredient ingredient : ingredients) {
            System.out.println(ingredient.getName());
        }
    }
    private void task_6() throws IOException {
        System.out.print("Count shampoos by price: ");
        String input = reader.readLine();

        BigDecimal priceValue = new BigDecimal(input);

        long count = this.shampooRepository.countShampoosByPriceLessThan(priceValue);

        System.out.println(count);
    }
    private void task_7() throws IOException {
        System.out.print("Select shampoos by ingredients names, separated by comma and space (\", \"): ");
        List<String> ingredientsNames = Arrays.stream(reader.readLine().split(",\\s+")).toList();

        Set<Ingredient> ingredients = this.ingredientsRepository.findAllByNameIn(ingredientsNames);

        Set<String> names = this.ingredientsRepository
                .findByIngredientsIn(ingredients)
                .stream()
                .map(Shampoo::getBrand)
                .collect(Collectors.toSet());

        for (String name : names) {
            System.out.println(name);
        }
    }
    private void task_8() throws IOException {
        System.out.print("Select shampoos by ingredients count: ");
        int count = Integer.parseInt(reader.readLine());

        List<Shampoo> shampoos = this.ingredientsRepository.findShampoosWithIngredientCountGreaterThan(count);

        for (Shampoo shampoo : shampoos) {
            System.out.println(shampoo.getBrand());
        }
    }
    @Transactional
    public void task_9() throws IOException {
        System.out.print("Delete ingredient by name: ");
        String name = reader.readLine();

        this.ingredientsRepository.deleteIngredientByName(name);
    }
    @Transactional
    public void task_10() throws IOException {
        this.ingredientsRepository.increasePriceByTenPercent();
    }
    @Transactional
    public void task_11() throws IOException {
        System.out.print("Update ingredients by names, separated by comma and space (\", \"): ");
        Set<String> ingredientsNames = Arrays.stream(reader.readLine().split(",\\s+")).collect(Collectors.toSet());

        this.ingredientsRepository.increasePriceByTenPercentOfIngredientsIn(ingredientsNames);
    }
}