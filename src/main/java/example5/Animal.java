package example5;

public class Animal {
    protected String name;

    public void eat(AnimalFood animalFood) {
        System.out.println(name + " ест: "+animalFood.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
