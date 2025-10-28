# Лабораторна робота 6: Принцип абстракції. Абстрактні класи та інтерфейси

## Завдання 1. Клас Animal

Даний наступний абстрактний клас

```java
abstract class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract String makeSound();
}
```
class Cat extends Animal {
     public Cat (String name) {
     super(name);
     }

    @Override
    public String makeSound() {
        return "Myau"; 
    }
}

Створіть клас `Dog` як підклас `Animal` та реалізуйте метод `makeSound()`. Створіть клас `Cat` як підклас `Animal` та реалізуйте метод `makeSound()`. Створіть у методі `main()` об'єкти кожного з підкласів та викличте метод `makeSound()`.

## Завдання 2. Інтерфейс Movable

Напишіть вихідний код класу `Point`, який реалізує наступний інтерфейс

```java
interface Movable {
    void setX(double x);
    void setY(double y);
    double getX();
    double getY();

    void moveTo(double x, double y);
}
```
class Point implements Movable {

    private double x;
    private double y;

    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    
    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public void moveTo(double newX, double newY) {
        this.x = newX;
        this.y = newY;
    }

}
## Завдання 3. Клас Smartphone

Напишіть вихідний код класу `Smartphone`, який реалізує такі інтерфейси

```java
interface GPS {
    double[] getCoordinates();
}

interface Cellular {
    void makeCall();
    void receiveCall();
}
```

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




## Завдання 4. Інтерфейс Comparable

```java
class Car {

    private int price;
    private int year; // рік виготовлення
    private int horsePower;

    // Додайте конструктор з трьома аргументами

    // Додайте гетери та сетери
}
```

Зробіть так, щоб клас реалізовував інтерфейс `Comparable`. Напишіть вихідний код методу `compareTo()`. Логіка методу така:

- спочатку порівнюється ціна автомобілів, "більше" той автомобіль, у якого менша ціна;
- якщо ціни рівні, то порівнюється рік випуску автомобіля, "більше" той автомобіль, який менший за віком;
- якщо вік однаковий, то автомобілі порівнюються за кількістю кінських сил. "Більше" той автомобіль, у якого кінських сил більше.

> Не використовуйте типізований `Comparable`! Для порівняння використовуйте лише арифметичні оператори.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Car implements Comparable {

    private int price;
    private int year;
    private int horsePower;


    public Car(int price, int year, int horsePower) {
        this.price = price;
        this.year = year;
        this.horsePower = horsePower;
    }


    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public int getHorsePower() { return horsePower; }
    public void setHorsePower(int horsePower) { this.horsePower = horsePower; }


    @Override
    public String toString() {
        return "Car [Ціна=" + price + ", Рік=" + year + ", к.с.=" + horsePower + "]";
    }


    // Крок 3: Реалізуємо метод compareTo() згідно з нашою логікою
    @Override
    public int compareTo(Object o) {
        // Обов'язкова перевірка типу, оскільки ми використовуємо нетипізований Comparable
        if (!(o instanceof Car)) {
            return 0; // Не можемо порівняти, вважаємо їх рівними
        }
        Car other = (Car) o; // Приведення типу до Car

        // --- Логіка порівняння ---

        // Правило 1: Спочатку порівнюємо ціну. "Більше" той, у кого ціна МЕНША.
        // Це зворотний порядок, тому порівнюємо other.price з this.price
        if (this.price != other.price) {
            return other.price - this.price; // Якщо this.price=10, other.price=20, результат буде 10 (додатний) -> other "менший"
        }
        
        // Якщо ціни однакові, переходимо до наступного правила
        
        // Правило 2: Порівнюємо рік випуску. "Більше" той, хто МОЛОДШИЙ (рік випуску більший).
        // Це прямий порядок.
        if (this.year != other.year) {
            return this.year - other.year; // Якщо this.year=2020, other.year=2018, результат 2 (додатний) -> this "більший"
        }

        // Якщо і роки однакові, переходимо до останнього правила

        // Правило 3: Порівнюємо кінські сили. "Більше" той, у кого їх БІЛЬШЕ.
        // Це прямий порядок.
        return this.horsePower - other.horsePower;
    }
}


// Клас для демонстрації роботи сортування
public class Main {
public static void main(String[] args) {
List<Car> cars = new ArrayList<>();
cars.add(new Car(20000, 2018, 150));
cars.add(new Car(15000, 2020, 180)); // Має бути першим (найнижча ціна)
cars.add(new Car(20000, 2022, 190)); // Має бути другим (ціна як у першого, але рік новіший)
cars.add(new Car(20000, 2018, 250)); // Має бути третім (ціна і рік як у першого, але кінських сил більше)
cars.add(new Car(30000, 2019, 300));

        System.out.println("Список до сортування:");
        for (Car car : cars) {
            System.out.println(car);
        }

        // Магія! Collections.sort використовує наш метод compareTo() для сортування
        Collections.sort(cars);

        System.out.println("\nСписок після сортування:");
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}



## Завдання 5. Додаток Draw

Скопіюйте та модифікуйте додаток `Draw` з лабораторної роботи №4 таким чином, щоб додаток використовував механізм абстрактних класів.

import java.awt.Point;
import java.awt.Shape;

/**
* Це наше "креслення" або шаблон для всіх фігур, які можна намалювати.
* Він містить спільні дані (точки) та оголошує спільну поведінку (getShape).
  */
  public abstract class AbstractShape {

  // Поля, спільні для всіх фігур
  protected Point startPoint;
  protected Point endPoint;

  // Конструктор для ініціалізації
  public AbstractShape() {
  this(new Point(0, 0), new Point(0, 0));
  }

  public AbstractShape(Point startPoint, Point endPoint) {
  this.startPoint = startPoint;
  this.endPoint = endPoint;
  }

  // --- АБСТРАКТНИЙ МЕТОД ---
  // Це "контракт". Кожен дочірній клас (Rectangle, Ellipse)
  // ЗОБОВ'ЯЗАНИЙ надати свою власну реалізацію цього методу.
  // Він каже, ЯК саме перетворити startPoint та endPoint на конкретну фігуру java.awt.Shape.
  public abstract Shape getShape();


    // --- ЗВИЧАЙНІ МЕТОДИ ---
    // Цей код однаковий для всіх, тому ми пишемо його тут один раз.
    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }
}


import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

// Rectangle ТЕПЕР є конкретною реалізацією нашого шаблону AbstractShape
public class Rectangle extends AbstractShape {

    // Реалізуємо "обіцянку" батьківського класу
    @Override
    public Shape getShape() {
        // Логіка для створення прямокутника на основі двох точок
        int x = Math.min(startPoint.x, endPoint.x);
        int y = Math.min(startPoint.y, endPoint.y);
        int width = Math.abs(startPoint.x - endPoint.x);
        int height = Math.abs(startPoint.y - endPoint.y);
        return new Rectangle2D.Float(x, y, width, height);
    }
}

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

// Ellipse - це також реалізація AbstractShape
public class Ellipse extends AbstractShape {

    @Override
    public Shape getShape() {
        // Логіка для створення еліпса (аналогічна до прямокутника)
        int x = Math.min(startPoint.x, endPoint.x);
        int y = Math.min(startPoint.y, endPoint.y);
        int width = Math.abs(startPoint.x - endPoint.x);
        int height = Math.abs(startPoint.y - endPoint.y);
        return new Ellipse2D.Float(x, y, width, height);
    }
}

## Завдання 6. Додаток SortingList

В даному репозиторії присутній модуль `list`, який містить додаток для виведення списку студентів та дозволяє відсортувати їх за такими полями: ім'я, прізвище, середній бал.

В додатку вже реалізовано сортування студентів за ім'ям.

Завдання полягає в наступному:

- доробити додаток, щоб за натисканням на відповідні кнопки відбувалося сортування студентів за прізвищем та за середнім балом;
- **завдання на додаткові бали** - допрацюйте додаток таким чином, щоб при повторному натисканні на ту саму кнопку сортування здійснювалося зворотне сортування студентів. Тобто, при першому натисканні на кнопку "Сортування за ім'ям" студенти сортувалися у прямому порядку (за зростанням), а при повторному натисканні на цю ж кнопку, студенти сортувалися у зворотному порядку (за спаданням).

> Список студентів знаходиться в колекції `students`, для сортування необхідно викликати у колекції метод `sort()` і цей метод передати об'єкт компаратора.

### Що таке компаратор?

Базова операція для майже будь-якого сортування – порівняння двох елементів. Якщо ви сортуєте звичайні числа або рядки, порівняння відбувається елементарно за всім відомими правилами. Але що робити, якщо ви хочете відсортувати об'єкти, які можуть мати десятки полів різних типів?

Для цього існує так званий компаратор. Компаратор Java - це об'єкт класу, який реалізує інтерфейс `Comparator`. Інтерфейс визначає лише один метод `compare()`, який приймає на вхід два об'єкти типу `Object`. 

Якщо перший об'єкт "менше" - метод повертає від'ємне число (зазвичай це просто -1, але може бути і будь-яке інше від'ємне число), якщо перший об'єкт "більше" - метод повертає позитивне число (зазвичай це 1, але може бути будь-яке інше позитивне число), якщо об'єкти "рівні" - метод повертає 0.
Завдання програміста - прописати потрібну логіку порівняння та повернути -1/0/1 у тому чи іншому випадку.

Ви створюєте клас, вказуєте, що цей клас реалізує інтерфейс `Comparator` та у методі `compare()` описуєте логіку порівняння двох об'єктів. У випадку порівняння двох студентів по імені код компаратора виглядає наступним чином

```java
public class NameSorter implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Student && o2 instanceof Student) {
            Student s1 = (Student) o1;
            Student s2 = (Student) o2;
            return s1.getName().compareTo(s2.getName());
        }
        return 0;
    }
}
```

Зверніть увагу, що спочатку ми повинні переконатися, що обидва об'єкти є об'єктами класу `Student`, після чого робимо низхідне перетворення.
У цьому випадку ми порівнюємо два поля name у двох об'єктів класу `Student`. Так як це тип `String`, нам не потрібно порівнювати рядки «вручну», ми просто можемо скористатися методом `compareTo()`, який є у будь-якого об'єкта класу `String`.
