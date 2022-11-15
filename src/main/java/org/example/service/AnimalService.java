package org.example.service;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.example.model.Animal;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class AnimalService {

    File file = new File("src/main/resources/animal.json");

    public void serialize(Animal animal) {
        JsonMapper jsonMapper = new JsonMapper();
        try {
            jsonMapper.writeValue(file, animal);
        } catch (IOException e) {
            System.out.println("Can not create file: " + file);
        }
    }

    public void serialize(List<Animal> animals) {
        JsonMapper jsonMapper = new JsonMapper();
        try {
            jsonMapper.writeValue(file, animals);
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
}
