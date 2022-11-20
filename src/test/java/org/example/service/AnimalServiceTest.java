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
    public void serializeListTest() {
        animalService.serializeNew(firstAnimal);
        animalService.serializeNew(secondAnimal);
        animalService.serializeNew(thirdAnimal);
    }

    @Test
    public void deserializeListTest() {
        List<Animal> animals = animalService.deserializeList();
        Assert.assertEquals(List.of(firstAnimal, secondAnimal, thirdAnimal), animals);
    }

    @Test
    public void removeAnimalTest() {
        List<Animal> animalsBefore = animalService.deserializeList();
        int sizeBefore = animalsBefore.size();
        animalService.removeAnimal("Mew");
        List<Animal> animalsAfter = animalService.deserializeList();
        int sizeAfter = animalsAfter.size();
        Assert.assertNotEquals(sizeBefore, sizeAfter);
    }
}
