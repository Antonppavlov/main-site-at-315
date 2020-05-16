package example9;

public class Start {
    public static void main(String[] args) {
        AnimalFood purinaOne = new AnimalFood();
        purinaOne.setName("Purina one общая");

        Dog lord = new Dog("Лорд");
        lord.barking();

        Cat tom = new Cat("Том");
        tom.meows();

        Animal[] zoo = {lord, tom};

        for (Animal animal: zoo) {
            animal.eat(purinaOne);
            animal.swimming();
        }

        Security[] animals2 = {lord, tom};

        for (Security animal:animals2){
            animal.houseSecurity();
        }
    }
}
