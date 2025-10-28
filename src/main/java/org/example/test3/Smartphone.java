package org.example.test3;

class Smartphone implements GPS, Cellular {

    private String model;


    @Override
    public double[] getCoordinates() {
        double[] coords = {46.4858, 30.7437}; // Приклад координат
        System.out.println("GPS: Визначено місцезнаходження.");
        return coords;
    }

    // Реалізація методів з інтерфейсу Cellular
    @Override
    public void makeCall() {
        System.out.println("Cellular: Вихідний дзвінок...");
    }

    @Override
    public void receiveCall() {
        System.out.println("Cellular: Вхідний дзвінок!");
    }
}