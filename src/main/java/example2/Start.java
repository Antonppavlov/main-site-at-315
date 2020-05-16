package example2;

public class Start {
    public static void main(String[] args) {
        CatFood catFood = new CatFood();
        catFood.setName("Kitti Cat");
        Cat cat = new Cat();
        cat.eat(catFood);
    }
}
