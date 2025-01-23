import java.util.ArrayList;
import java.util.List;

// 1. Класс "Человек"
class Person {
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void printInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Gender: " + gender);
    }

    public void increaseAge() {
        age++;
    }

    public void changeName(String newName) {
        this.name = newName;
    }
}

// 2. Наследование: Класс "Работник" и "Менеджер"
class Worker extends Person {
    protected double salary;

    public Worker(String name, int age, String gender, double salary) {
        super(name, age, gender);
        this.salary = salary;
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
}

// 3. Полиморфизм: Животные
interface Animal {
    void makeSound();
}

class Dog implements Animal {
    public void makeSound() {
        System.out.println("Woof!");
    }
}

class Cat implements Animal {
    public void makeSound() {
        System.out.println("Meow!");
    }
}

class Cow implements Animal {
    public void makeSound() {
        System.out.println("Moo!");
    }
}

// 4. Абстрактный класс "Транспорт"
abstract class Transport {
    abstract void move();
}

class Car extends Transport {
    void move() {
        System.out.println("Car is moving");
    }
}

class Bike extends Transport {
    void move() {
        System.out.println("Bike is moving");
    }
}

// 5. Класс "Книга" и "Библиотека"
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
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void findByAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                System.out.println("Found book by: " + author);
            }
        }
    }
}

// 6. Инкапсуляция: Банк
class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

// 7. Счетчик объектов
class Counter {
    private static int count = 0;

    public Counter() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}

// 8. Площадь фигур
abstract class Shape {
    abstract double getArea();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    double getArea() {
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

    double getArea() {
        return width * height;
    }
}

// 9. Наследование: Животные и их движения
class AnimalMovement {
    void move() {}
}

class Fish extends AnimalMovement {
    void move() {
        System.out.println("Fish is swimming");
    }
}

class Bird extends AnimalMovement {
    void move() {
        System.out.println("Bird is flying");
    }
}

class DogMovement extends AnimalMovement {
    void move() {
        System.out.println("Dog is running");
    }
}

// 10. Работа с коллекциями: Университет
class Student {
    private String name;
    private String group;
    private double grade;

    public Student(String name, String group, double grade) {
        this.name = name;
        this.group = group;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
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
}

// 11. Класс "Магазин"
class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }
}

class Store {
    private List<Product> products;

    public Store() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}

// 12. Интерфейс "Платежная система"
interface PaymentSystem {
    void pay();
    void refund();
}

class CreditCard implements PaymentSystem {
    public void pay() {
        System.out.println("Paying with Credit Card");
    }

    public void refund() {
        System.out.println("Refunding to Credit Card");
    }
}

class PayPal implements PaymentSystem {
    public void pay() {
        System.out.println("Paying with PayPal");
    }

    public void refund() {
        System.out.println("Refunding to PayPal");
    }
}

// 13. Генерация уникальных идентификаторов
class UniqueID {
    private static int idCounter = 0;

    public static int generateID() {
        return idCounter++;
    }
}

// 14. Класс "Точка" и "Прямоугольник"
class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class RectanglePoint {
    private Point topLeft;
    private Point bottomRight;

    public RectanglePoint(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }
}

// 15. Комплексные числа
class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(real + other.real, imaginary + other.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(real - other.real, imaginary - other.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        return new ComplexNumber(real * other.real - imaginary * other.imaginary,
                real * other.imaginary + imaginary * other.real);
    }

    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        return new ComplexNumber(
                (real * other.real + imaginary * other.imaginary) / denominator,
                (imaginary * other.real - real * other.imaginary) / denominator
        );
    }
}

// 16. Перегрузка операторов: Матрица
class Matrix {
    private int[][] data;

    public Matrix(int rows, int cols) {
        data = new int[rows][cols];
    }

    public Matrix add(Matrix other) {
        int rows = data.length;
        int cols = data[0].length;
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return result;
    }

    public Matrix multiply(Matrix other) {
        int rows = data.length;
        int cols = other.data[0].length;
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = 0;
                for (int k = 0; k < other.data.length; k++) {
                    result.data[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }
        return result;
    }
}

// 17. Создание игры с использованием ООП
class Player {
    private String name;
    private int health;

    public Player(String name) {
        this.name = name;
        this.health = 100;
    }

    public void attack(Enemy enemy) {
        System.out.println(name + " attacks " + enemy.getName());
        enemy.takeDamage(10);
    }
}

class Enemy {
    private String name;
    private int health;

    public Enemy(String name) {
        this.name = name;
        this.health = 50;
    }

    public String getName() {
        return name;
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(name + " takes " + damage + " damage. Health left: " + health);
    }
}

// 18. Автоматизированная система заказов
class Order {
    private List<Product> products;
    private double totalAmount;

    public Order() {
        products = new ArrayList<>();
        totalAmount = 0.0;
    }

    public void addProduct(Product product) {
        products.add(product);
        totalAmount += product.getPrice(); // Доступ через метод-геттер
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}

class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }
}

// 19. Наследование: Электроника
class Device {
    protected String brand;

    public Device(String brand) {
        this.brand = brand;
    }

    public void turnOn() {
        System.out.println("Device is turned on");
    }

    public void turnOff() {
        System.out.println("Device is turned off");
    }
}

class Smartphone extends Device {
    public Smartphone(String brand) {
        super(brand);
    }

    public void takePhoto() {
        System.out.println("Taking a photo");
    }
}

class Laptop extends Device {
    public Laptop(String brand) {
        super(brand);
    }
}

// 20. Игра "Крестики-нолики"
class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void play(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
            board[row][col] = currentPlayer;
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        } else {
            System.out.println("Invalid move");
        }
    }

    public void printBoard() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}

// Главный класс для тестирования
public class Main {
    public static void main(String[] args) {
        // Инициализация объектов для проверки работы
        // Человек
        Person person = new Person("John", 25, "Male");
        person.printInfo();
        person.increaseAge();
        person.printInfo();

        // Работник и Менеджер
        Worker worker = new Worker("Alice", 30, "Female", 50000);
        Manager manager = new Manager("Bob", 40, "Male", 80000);
        manager.addSubordinate(worker);

        // Полиморфизм животных
        Animal[] animals = {new Dog(), new Cat(), new Cow()};
        for (Animal animal : animals) {
            animal.makeSound();
        }

        // Транспорт
        Transport car = new Car();
        Transport bike = new Bike();
        car.move();
        bike.move();

        // Библиотека
        Library library = new Library();
        library.addBook(new Book("1984", "George Orwell", 1949));
        library.findByAuthor("George Orwell");

        // Банк
        BankAccount account = new BankAccount("123456");
        account.deposit(1000);
        account.withdraw(250);
        System.out.println("Balance: $" + account.getBalance());

        // Счетчик объектов
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        System.out.println("Number of Counter objects created: " + Counter.getCount());

        // Площадь фигур
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        System.out.println("Circle area: " + circle.getArea());
        System.out.println("Rectangle area: " + rectangle.getArea());

        // Игровые объекты
        Player player = new Player("Hero");
        Enemy enemy = new Enemy("Villain");
        player.attack(enemy);

        // Заказы
        Order order = new Order();
        Product product = new Product("Sample Product", 15.99, 1);
        order.addProduct(product);
        System.out.println("Total Order Amount: $" + order.getTotalAmount());

        // Устройства
        Device phone = new Smartphone("Samsung");
        phone.turnOn();
        ((Smartphone) phone).takePhoto();
        phone.turnOff();

        // Игра "Крестики-нолики"
        TicTacToe game = new TicTacToe();
        game.printBoard();
        game.play(0, 0);
        game.printBoard();
        game.play(1, 1);
        game.printBoard();
        game.play(0, 1);
        game.printBoard();
        game.play(1, 0);
        game.printBoard();
    }
}