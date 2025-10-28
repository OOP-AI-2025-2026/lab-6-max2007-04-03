package org.example.test1;

class Cat extends Animal {
    public Cat (String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "Myau";
    }
}