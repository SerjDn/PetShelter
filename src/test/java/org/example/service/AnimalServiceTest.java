package org.example.service;

import org.example.model.Animal;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AnimalServiceTest {

    private final AnimalService animalService = new AnimalService();
    private final Animal firstAnimal = new Animal("dog", true, "Wolfie", 4);
    private final Animal secondAnimal = new Animal("cat", false, "Mew", 3);
    private final Animal thirdAnimal = new Animal("pig", true, "Pinky", 1);

    @Test
    public void serializeListTest() {
        animalService.serializeList(firstAnimal);
        animalService.serializeList(secondAnimal);
        animalService.serializeList(thirdAnimal);
    }

    @Test
    public void deserializeListTest() {
        animalService.removeAll();
        animalService.serializeList(secondAnimal);
        List<Animal> animals = animalService.deserializeList();
        Assert.assertEquals(List.of(secondAnimal), animals);
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
