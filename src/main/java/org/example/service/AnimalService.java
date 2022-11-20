package org.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.example.model.Animal;

import java.io.*;
import java.util.*;

public class AnimalService {

    File file = new File("src/main/resources/animal.json");

    public void serialize(Animal animal) {
        JsonMapper jsonMapper = new JsonMapper();
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(file, true))) {
            jsonMapper.writeValue(printWriter, animal);
        } catch (IOException e) {
            System.out.println("Can not create file: " + file);
        }
    }

    public void serialize(List<Animal> animals) {
        JsonMapper jsonMapper = new JsonMapper();
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(file, true))) {
            jsonMapper.writeValue(printWriter, animals);
        } catch (IOException e) {
            System.out.println("Can not create file: " + file);
        }
    }

    public void serializeNew(Animal animal) {
        JsonMapper jsonMapper = new JsonMapper();
        try {
            if (deserializeList() != null) {
                List<Animal> animals = deserializeList();
                animals.add(animal);
                jsonMapper.writeValue(file, animals);
            } else {
                jsonMapper.writeValue(file, List.of(animal));
            }
        } catch (IOException e) {
            System.out.println("Can not create file: " + file);
        }
    }

    public Optional<Animal> deserialize() {
        JsonMapper jsonMapper = new JsonMapper();
        try {
            return Optional.of(jsonMapper.readValue(file, Animal.class));
        } catch (IOException e) {
            System.out.println("Can not read file: " + file);
            return Optional.empty();
        }
    }

    public List<Animal> deserializeList() {
        JsonMapper jsonMapper = new JsonMapper();
        try {
            List<Animal> animals = jsonMapper.readValue(file, new TypeReference<>() {
            });
            return animals;
        } catch (IOException e) {
            System.out.println("Can not read file: " + file);
            return null;
        }
    }

    public void removeAnimal(String name) {
        JsonMapper jsonMapper = new JsonMapper();
        try {
            List<Animal> animals = jsonMapper.readValue(file, new TypeReference<>() {
            });
            for (int i = 0; i < animals.size(); i++) {
                if (animals.get(i).getName().equals(name)) {
                    System.out.println(animals.get(i));
                    animals.remove(i);
                }
            }

            jsonMapper.writeValue(file, animals);
        } catch (IOException e) {
            System.out.println("Can not read file: " + file);
        }
    }
}
