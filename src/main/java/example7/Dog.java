package example7;

public class Dog extends Animal {

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

}
