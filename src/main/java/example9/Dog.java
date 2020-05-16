package example9;

public class Dog extends Animal implements Security{

    public Dog(String name) {
        super(name);
    }

    @Override
    public void swimming() {
        System.out.println(name+" плавает с радостью");
    }

    public void barking(){
        System.out.println(name+" гавкает");
    }

//    @Override
    public void houseSecurity() {
        System.out.println(name+" гавкает при посторонних");
    }
}
