package example4;

public class Animal {
    protected String name;

    public void eat() {
        System.out.println(name + " ест");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
