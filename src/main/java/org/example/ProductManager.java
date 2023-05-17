package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class ProductManager {
    private final Path productPath;
    public ProductManager() throws URISyntaxException {
        ClassLoader classLoader = ProductManager.class.getClassLoader();

        this.productPath = Paths.get(Objects.requireNonNull(classLoader.getResource("products.txt")).toURI());
    }
    public List<String> getAllProducts() throws IOException {
        return Files.readAllLines(productPath, StandardCharsets.UTF_8);
    }

    public void addProduct(String product) throws IOException {
        HashSet<String> products = new HashSet<>(getAllProducts());

        if (!products.contains(product)){
            Files.writeString(productPath, System.lineSeparator() + product, StandardOpenOption.APPEND);
        } else {
            System.out.println("Product is already in your fridge!");
        }
    }

    public void deleteProduct(String product) throws IOException {
        HashSet<String> products = new HashSet<>(getAllProducts());

        if (products.contains(product)) {
            products.remove(product);
            String productsToSave = String.join(System.lineSeparator(), products);
            Files.writeString(productPath, productsToSave);
        } else {
            System.out.printf("You don't have %s in your fridge!%n", product);
        }
    }
}
