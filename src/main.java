import java.util.*;

// Главная функция
public class main {
    public static void main(String[] args) {
        // Задача 1
        Person person = new Person("Алиса", 18, "Женщина");
        person.displayInfo();
        person.increaseAge();
        person.setName("Алисия");
        person.displayInfo();

        // Задача 2
        Worker worker = new Worker("Александр", 22, "Мужчина", 50000);
        Manager manager = new Manager("Наталия", 20, "Женщина", 80000);
        manager.addSubordinate(worker);
        manager.displaySubordinates();

        // Задача 3
        Animal[] animals = {new Dog(), new Cat(), new Cow()};
        for (Animal animal : animals) {
            animal.makeSound();
        }

        // Задача 4
        Transport car = new Car();
        Transport bike = new Bike();
        car.move();
        bike.move();

        // Задача 5
        Library library = new Library();
        library.addBook(new Book("Книга1", "Автор1", 2000));
        library.addBook(new Book("Книга2", "Автор2", 2010));
        library.findBooksByAuthor("Автор1");
        library.findBooksByYear(2010);

        // Задача 6
        BankAccount account = new BankAccount("123456");
        account.deposit(1000);
        account.withdraw(500);
        System.out.println("Баланс: " + account.getBalance());

        // Задача 7
        new Counter();
        new Counter();
        System.out.println("Количество объектов Counter: " + Counter.getCount());

        // Задача 8
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        System.out.println("Площадь круга: " + circle.getArea());
        System.out.println("Площадь прямоугольника: " + rectangle.getArea());

        // Задача 9
        AnimalMovement fish = new Fish();
        AnimalMovement bird = new Bird();
        AnimalMovement dog = new DogMovement();
        fish.move();
        bird.move();
        dog.move();

        // Задача 10
        University university = new University();
        university.addStudent(new Student("Дэвид", "CS101", 3.5));
        university.addStudent(new Student("Ева", "CS102", 4.0));
        university.sortByName();
        university.filterByGrade(3.8);
    }
}

// Задача 1: Класс "Человек"
class Person {
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void displayInfo() {
        System.out.println("Имя: " + name + ", Возраст: " + age + ", Пол: " + gender);
    }

    public void increaseAge() {
        age++;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// Задача 2: Наследование: Класс "Работник" и "Менеджер"
class Worker extends Person {
    private double salary;

    public Worker(String name, int age, String gender, double salary) {
        super(name, age, gender);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends Worker {
    private List<Worker> subordinates;

    public Manager(String name, int age, String gender, double salary) {
        super(name, age, gender, salary);
        subordinates = new ArrayList<>();
    }

    public void addSubordinate(Worker worker) {
        subordinates.add(worker);
    }

    public void displaySubordinates() {
        for (Worker w : subordinates) {
            w.displayInfo();
        }
    }
}

// Задача 3: Полиморфизм: Животные
interface Animal {
    void makeSound();
}

class Dog implements Animal {
    public void makeSound() {
        System.out.println("Гав!");
    }
}

class Cat implements Animal {
    public void makeSound() {
        System.out.println("Мяу!");
    }
}

class Cow implements Animal {
    public void makeSound() {
        System.out.println("Муу!");
    }
}

// Задача 4: Абстрактный класс "Транспорт"
abstract class Transport {
    abstract void move();
}

class Car extends Transport {
    public void move() {
        System.out.println("Машина едет по дороге.");
    }
}

class Bike extends Transport {
    public void move() {
        System.out.println("Велосипед едет по дороге.");
    }
}

// Задача 5: Класс "Книга" и "Библиотека"
class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public void displayInfo() {
        System.out.println("Название: " + title + ", Автор: " + author + ", Год: " + year);
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void findBooksByAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                book.displayInfo();
            }
        }
    }

    public void findBooksByYear(int year) {
        for (Book book : books) {
            if (book.getYear() == year) {
                book.displayInfo();
            }
        }
    }
}

// Задача 6: Инкапсуляция: Банк
class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}

// Задача 7: Счетчик объектов
class Counter {
    private static int count = 0;

    public Counter() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}

// Задача 8: Площадь фигур
abstract class Shape {
    abstract double getArea();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }
}

// Задача 9: Наследование: Животные и их движения
class AnimalMovement {
    public void move() {
        System.out.println("Животное как-то передвигается.");
    }
}

class Fish extends AnimalMovement {
    public void move() {
        System.out.println("Рыба плывёт.");
    }
}

class Bird extends AnimalMovement {
    public void move() {
        System.out.println("Птица летит.");
    }
}

class DogMovement extends AnimalMovement {
    public void move() {
        System.out.println("Собака бежит.");
    }
}

// Задача 10: Работа с коллекциями: Университет
class Student {
    private String name;
    private String group;
    private double grade;

    public Student(String name, String group, double grade) {
        this.name = name;
        this.group = group;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public void displayInfo() {
        System.out.println("Имя: " + name + ", Группа: " + group + ", Оценка: " + grade);
    }
}

class University {
    private List<Student> students;

    public University() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void sortByName() {
        students.sort(Comparator.comparing(Student::getName));
    }

    public void filterByGrade(double minGrade) {
        for (Student student : students) {
            if (student.getGrade() >= minGrade) {
                student.displayInfo();
            }
        }
    }
}
