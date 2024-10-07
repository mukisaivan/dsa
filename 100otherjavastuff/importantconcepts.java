
import java.util.ArrayList;

public class importantconcepts {

  public static void main(String[] args) {
    Box<String> b = new Box<>();

    b.setItem("box item");

    String ans = b.getItem();

    System.out.println(ans);

    Pairs p = new Pairs(ans, ans);

  }

}

class Box<T> {

  private T item;

  public void setItem(T item) {
    this.item = item;
  }

  public T getItem() {
    return item;
  }

}

class MathUtil {

  public <T extends Number> void printDoubleValue(T number) {
    System.out.println(number.doubleValue());
  }

  void printNumbers(ArrayList<? extends Number> numbers) {
    for (Object number : numbers) {
      System.out.println(number);
    }
  }

}

class Pairs<K, V> {

  private final K key;
  private final V value;

  public Pairs(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }
}

// ---------------------- ENCAPSULATION ---------------

/*
 * 
 * You make data members private, but provide public methods to access and
 * update them. This is called data hiding.
 * 
 * restricts direct access to some of the object's components, which is
 * essential for protecting the integrity of an object’s data.
 * 
 * 
 */

class Encapsulation_Car {
  private String model; // This variable is encapsulated

  // Setter method to update model
  public void setModel(String model) {
    this.model = model;
  }

  // Getter method to retrieve model
  public String getModel() {
    return model;
  }
}

// ---------------------- INHERITANCE ---------------

/*
 * 
 * Inheritance allows a class (child class or subclass) to inherit properties
 * and behaviors (fields and methods) from another class (parent class or
 * superclass)
 */

class Vehicle {
  void startEngine() {
    System.out.println("Engine started.");
  }
}

// Car inherits the properties and behavior of Vehicle
class Car extends Vehicle {
  void honk() {
    System.out.println("Car honks.");
  }
}

// ---------------------- POLYMORPHISM ---------------

/*
 * Polymorphism allows objects to be treated as instances of their parent class
 * while using different forms of a method or behavior
 */

class MathOperations {
  // Add two integers
  int add(int a, int b) {
    return a + b;
  }

  // Add three integers
  int add(int a, int b, int c) {
    return a + b + c;
  }

  // Add two doubles
  double add(double a, double b) {
    return a + b;
  }
}

class Main {
  public static void main(String[] args) {
    MathOperations math = new MathOperations();
    System.out.println(math.add(2, 3)); // Calls add(int, int)
    System.out.println(math.add(2, 3, 4)); // Calls add(int, int, int)
    System.out.println(math.add(2.5, 3.5)); // Calls add(double, double)
  }
}

// ---------------------- ABSTRACTION ---------------

/*
 * Abstraction hides the complexity of a system by providing a simplified
 * interface and only showing essential details
 */

abstract class Animal {
  // Abstract method (does not have a body)
  abstract void sound();

  // Regular method
  void sleep() {
    System.out.println("This animal is sleeping.");
  }
}

class Dog extends Animal {
  @Override
  void sound() {
    System.out.println("The dog barks.");
  }
}

class Main2 {
  public static void main(String[] args) {
    Animal myDog = new Dog();
    myDog.sound(); // Must override sound()
    myDog.sleep(); // Uses the inherited sleep()
  }
}
