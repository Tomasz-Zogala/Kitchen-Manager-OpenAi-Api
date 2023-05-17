package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Show products");
            System.out.println("2. Add product");
            System.out.println("3. Delete product");
            System.out.println("4. Show 3 possible ideas for breakfast");
            System.out.println("5. Show 3 possible ideas for dinner");
            System.out.println("6. Get healthy products recommendation");
            System.out.println("7. Quit");
            System.out.println("Choose activity:");

            int choice = Integer.parseInt(scanner.nextLine());
            ProductManager productManager = new ProductManager();
            ChatGPTHelper chatGPTHelper = new ChatGPTHelper();

            switch (choice) {
                case 1 -> {
                    System.out.println("Products");
                    productManager.getAllProducts().forEach(System.out::println);
                }
                case 2 -> {
                    System.out.println("Which product do you want to add");
                    String product = scanner.nextLine();
                    productManager.addProduct(product);
                }
                case 3 -> {
                    System.out.println("Which product do you want to delete");
                    String product = scanner.nextLine();
                    productManager.deleteProduct(product);
                }
                case 4 -> {
                    System.out.println("Breakfast ideas from ChatGPT");
                    String breakfastIdea = chatGPTHelper.getBreakfastIdea(productManager.getAllProducts());

                    System.out.println(breakfastIdea);
                }
                case 5 -> {
                    System.out.println("Dinner ideas from ChatGPT");
                    String dinnerIdea = chatGPTHelper.getDinnerIdea(productManager.getAllProducts());

                    System.out.println(dinnerIdea);
                }
                case 6-> {
                    System.out.println("Healthy products recommended by ChatGPT");
                    String healthyProductsRecommendation = chatGPTHelper.getHealthyProductsRecommendation(productManager.getAllProducts());

                    System.out.println(healthyProductsRecommendation);
                }
                case 7 -> {
                    System.out.println("Bon Appetit");
                    System.exit(0);
                }
            }
        }
    }
}