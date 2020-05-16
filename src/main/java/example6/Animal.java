package example6;

public class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat(AnimalFood animalFood) {
        System.out.println(name + " ест: "+animalFood.getName());
    }

    public String getName() {
        return name;
    }

}
