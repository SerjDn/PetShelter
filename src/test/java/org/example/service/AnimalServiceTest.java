package org.example.service;

import org.example.model.Animal;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class AnimalServiceTest {

    private final AnimalService animalService = new AnimalService();
    private final Animal firstAnimal = new Animal("dog", true, "Wolfie", 4);
    private final Animal secondAnimal = new Animal("cat", false, "Mew", 3);
    private final Animal thirdAnimal = new Animal("pig", true, "Pinky", 1);

    @Test
    public void serializeTest() {
        animalService.serialize(firstAnimal);
    }

    @Test
    public void serializeListTest() {
        animalService.serialize(List.of(secondAnimal, thirdAnimal));
    }

    @Test
    public void deserializeTest() {
        Optional<Animal> deserialize = animalService.deserialize();
        Assert.assertEquals(firstAnimal, deserialize.orElse(null));
    }
}
