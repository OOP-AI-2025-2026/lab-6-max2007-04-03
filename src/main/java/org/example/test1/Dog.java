package org.example.test1;

class Dog extends Animal {

    // 1. Конструктор
    public Dog(String name) {
        super(name);
    }

    // 2. Реалізація абстрактного методу
    @Override
    public String makeSound() {
        return "Woof";
    }
}