package ru.geekbrains.main.site.at.exceptions;

public class StackOverflowErrorExample {

    public static void main(String[] args) {
        example();
    }

    public static int example() {
        return example();
    }

}

