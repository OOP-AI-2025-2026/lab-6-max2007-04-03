package org.example.test2;

public class Main {
    public static void main(String[] args) {
        // Створюємо об'єкт класу Point
        Point point = new Point(1.0, 2.0);

        // Перевіряємо початкові координати
        System.out.println("Initial coordinates:");
        System.out.println("X: " + point.getX() + ", Y: " + point.getY());
        assert point.getX() == 1.0 : "Initial X is incorrect!";
        assert point.getY() == 2.0 : "Initial Y is incorrect!";

        // Змінюємо координати за допомогою setX() і setY()
        point.setX(5.5);
        point.setY(6.5);
        System.out.println("\nAfter setting new coordinates:");
        System.out.println("X: " + point.getX() + ", Y: " + point.getY());
        assert point.getX() == 5.5 : "Setting X failed!";
        assert point.getY() == 6.5 : "Setting Y failed!";

        // Перевіряємо роботу moveTo()
        point.moveTo(10.0, 15.0);
        System.out.println("\nAfter moving to new coordinates:");
        System.out.println("X: " + point.getX() + ", Y: " + point.getY());
        assert point.getX() == 10.0 : "MoveTo X failed!";
        assert point.getY() == 15.0 : "MoveTo Y failed!";

        // Перевіряємо роботу з від'ємними координатами
        point.moveTo(-7.0, -9.0);
        System.out.println("\nAfter moving to negative coordinates:");
        System.out.println("X: " + point.getX() + ", Y: " + point.getY());
        assert point.getX() == -7.0 : "Negative MoveTo X failed!";
        assert point.getY() == -9.0 : "Negative MoveTo Y failed!";

        System.out.println("\nAll tests passed successfully!");
    }
}
