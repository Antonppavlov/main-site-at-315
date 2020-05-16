package example7;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void swimming() {
        System.out.println(name+" не хочет плавать");
    }

    public void meows(){
        System.out.println(name+" мяукает");
    }

}
