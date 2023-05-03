package org.example;

import org.example.entity.Animal;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Animal();

        animal1.setAge(3);
        animal1.setName("Kot");
        animal1.setTail(true);

        AnimalHelper animalHelper = new AnimalHelper();

        animalHelper.addAnimal(animal1);
        animalHelper.getAnimalList();
        animalHelper.getAnimalById(1);
        animalHelper.deleteAnimalById(1);
    }
}