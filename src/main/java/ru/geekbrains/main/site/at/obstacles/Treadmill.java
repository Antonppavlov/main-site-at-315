package ru.geekbrains.main.site.at.obstacles;

import ru.geekbrains.main.site.at.participants.Runner;

public class Treadmill implements Obstacles {
    private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void check(Runner runner) {
        runner.run();
        boolean success = runner.getMaxLength() >= length;
        if (success) {
            System.out.println("Бегун " + runner.getName() + " выполнил испытание, пробежав дорожку длиной: " + length);
        } else {
            System.out.println("Бегун " + runner.getName() + " не пробежал дорожку длиной: " + length );
        }
    }
}