package example5;

public class Start {
    public static void main(String[] args) {
        AnimalFood animalFood = new AnimalFood();
        animalFood.setName("Purina one общая");

        Dog lord = new Dog();
        lord.setName("Лорд");
        lord.barking();

        Cat cat = new Cat();
        cat.setName("Том");
        cat.meows();

        Animal[] animals = {lord, cat};

        for (Animal animal: animals) {
            animal.eat(animalFood);
        }
    }
}
