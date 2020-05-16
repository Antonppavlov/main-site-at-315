package example9;

public class Cat extends Animal implements Security {

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

    public void houseSecurity() {
        System.out.println(name+" охраняет от мышей");
    }
}
