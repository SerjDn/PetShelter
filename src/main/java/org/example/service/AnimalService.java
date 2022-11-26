package org.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.example.model.Animal;

import java.io.*;
import java.util.*;

public class AnimalService {

    File file = new File("src/main/resources/animal.json");

    public void serializeList(Animal animal) {
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

    public List<Animal> deserializeList() {
        JsonMapper jsonMapper = new JsonMapper();
        try {
            return jsonMapper.readValue(file, new TypeReference<>() {});
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
            int size = animals.size();
            for (int i = 0; i < animals.size(); i++) {
                if (animals.get(i).getName().equals(name)) {
                    animals.remove(i);
                }
            }

            if (animals.size() == size) {
                System.out.println("There aren't animals with name " + "<" + name + ">");
            } else {
                System.out.println("Take care of " + "<" + name + ">" + "!");
            }

            jsonMapper.writeValue(file, animals);
        } catch (IOException e) {
            System.out.println("Can not read file: " + file);
        }
    }

    public void removeAll() {
        JsonMapper jsonMapper = new JsonMapper();
        try {
            List<Animal> animals = jsonMapper.readValue(file, new TypeReference<>() {
            });
            for (int i = 0; i < animals.size(); i++) {
                animals.remove(i);
                i--;
            }
            jsonMapper.writeValue(file, animals);
        } catch (IOException e) {
            System.out.println("Can not read file: " + file);
        }
    }
}
