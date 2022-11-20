package org.example;

import org.example.model.Animal;
import org.example.service.AnimalService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AnimalService animalService = new AnimalService();
        Scanner scanner = new Scanner(System.in);

//        Animal dog = new Animal("dog", true, "Wolfie", 4);
//        animalService.serialize(dog);
//        Animal cat = new Animal("cat", false, "Mew", 3);
//        animalService.serialize(cat);
//        Animal fish = new Animal("fish", false, "Golden", 1);
//        animalService.serialize(fish);
//        Animal pig = new Animal("pig", true, "Pinky", 2);
//        animalService.serialize(pig);

//        Animal dog = new Animal("dog", true, "Wolfie", 4);
//        Animal cat = new Animal("cat", false, "Mew", 3);
//        Animal fish = new Animal("fish", false, "Golden", 1);
//        Animal pig = new Animal("pig", true, "Pinky", 2);
//        animalService.serialize(List.of(dog, cat, fish, pig));
//
//        Animal dog = new Animal("dog", true, "Wolfie", 4);
//        animalService.serializeNew(dog);

        System.out.println("1 - add new");
        if (scanner.nextInt() == 1) {
            System.out.println("type:");
            String type = scanner.next();
            System.out.println("gender:");
            boolean gender = scanner.nextBoolean();
            System.out.println("name:");
            String name = scanner.next();
            System.out.println("age:");
            int age = scanner.nextInt();
            animalService.serializeNew(new Animal(type, gender, name, age));
        }

        System.out.println(animalService.deserializeList());
        System.out.println("======================================================");
        animalService.removeAnimal("Mew");

        scanner.close();
    }
}