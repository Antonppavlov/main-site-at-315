package example7;

public abstract class Animal {
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

    abstract public void swimming();

}
