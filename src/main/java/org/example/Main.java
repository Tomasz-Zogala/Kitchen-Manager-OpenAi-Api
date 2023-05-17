package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose activity");
            System.out.println("1. Show products");
            System.out.println("2. Add product");
            System.out.println("3. Remove product");
            System.out.println("4. Show 3 possible ideas for breakfast");
            System.out.println("5. Show 3 possible ideas for dinner");
            System.out.println("6. Get healthy products recommendation");
            System.out.println("7. Quit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Products");
                }
                case 2 -> {
                    System.out.println("Which product do you want to add");
                }
                case 3 -> {
                    System.out.println("Which product do you want to remove");
                }
                case 4 -> {
                    System.out.println("Breakfast ideas from ChatGPT");
                }
                case 5 -> {
                    System.out.println("Dinner ideas from ChatGPT");
                }
                case 6-> {
                    System.out.println("Healthy products recommended by ChatGPT");
                }
                case 7 -> {
                    System.out.println("Bon Appetit");
                }
            }
        }
    }
}