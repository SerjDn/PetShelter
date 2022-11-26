package org.example;

import org.example.model.Animal;
import org.example.service.AnimalService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AnimalService animalService = new AnimalService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                Hello! This is pet shelter. What do you want?
                1 - add animal
                2 - show animals
                3 - take animal (animal will be remove from shop-list)
                0 - exit
                """);
        while (scanner.hasNext()) {
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("type:");
                    String type = scanner.next();
                    System.out.println("gender:");
                    boolean gender = scanner.nextBoolean();
                    System.out.println("name:");
                    String name = scanner.next();
                    System.out.println("age:");
                    int age = scanner.nextInt();
                    animalService.serializeList(new Animal(type, gender, name, age));
                }
                case 2 -> System.out.println(animalService.deserializeList());
                case 3 -> {
                    System.out.println("Have you chosen a pet? Enter pet name:");
                    animalService.removeAnimal(scanner.next());
                }
                default -> {
                    System.out.println("Pet Shelter is closing...");
                    System.exit(0);
                }
            }
        }

        scanner.close();
    }
}
