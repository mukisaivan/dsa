class Animal: 
  def __init__(self, name = None, wild = None):
    self.name = name
    self.wild = wild

  def callanimal (self):
    print(f"{self.name} has been called")

anima  = Animal("gorilla")
anima.callanimal()



## OOP


# 1 classes ond objects

# Class: A blueprint or template for creating objects. It defines the attributes (data) and methods (functions) that the objects created from it will have.
# Object: An instance of a class. It is a specific implementation of the class with actual data.


# Defining a class
class Car:
    def __init__(self, make, model):  # Constructor method to initialize attributes
        self.make = make
        self.model = model

    def start_engine(self):  # Method to start the car's engine
        print(f"{self.make} {self.model} engine started.")

# Creating objects (instances) of the class
car1 = Car("Toyota", "Corolla")
car2 = Car("Honda", "Civic")

# Accessing attributes and methods
print(car1.make)  # Output: Toyota
car1.start_engine()  # Output: Toyota Corolla engine started.







# Encapsulation
# Encapsulation refers to the practice of restricting access to certain attributes or methods of an object, hiding the internal details, and exposing only what's necessary.
# You can make an attribute private by prefixing its name with double underscores (__).


class BankAccount:
    def __init__(self, balance):
        self.__balance = balance  # Private attribute

    def deposit(self, amount):
        self.__balance += amount

    def get_balance(self):
        return self.__balance

account = BankAccount(1000)
account.deposit(500)
print(account.get_balance())  # Output: 1500




# Inheritance
# Inheritance allows one class (called the child class) to inherit attributes and methods from another class (called the parent class).
# The child class can add its own attributes and methods or override existing ones.

class Animal:
    def sound(self):
        print("Some generic animal sound")
    
    def crying(self):
        print("crying")

class Dog(Animal):  # Dog class inherits from Animal class
    def sound(self):  # Override the sound method
        print("Bark!")

class Cat(Animal):  # Cat class inherits from Animal class
    def sound(self):
        print("Meow!")

dog = Dog()
dog.sound()  # Output: Bark!

cat = Cat()
cat.sound()  # Output: Meow!

cat.crying()





# 7. Polymorphism
# Polymorphism allows different classes to have methods with the same name but different implementations.
# In Python, this is often seen with method overriding, where a child class provides a specific implementation of a method that’s already defined in its parent class.


class Shape:
    def area(self):
        pass  # Placeholder method

class Circle(Shape):
    def __init__(self, radius):
        self.radius = radius

    def area(self):
        return 3.14 * self.radius ** 2

class Rectangle(Shape):
    def __init__(self, length, width):
        self.length = length
        self.width = width

    def area(self):
        return self.length * self.width

shapes = [Circle(5), Rectangle(4, 6)]
for shape in shapes:
    print(shape.area())  # Outputs area for both Circle and Rectangle



# Abstraction
# Abstraction is the concept of hiding complex details and showing only the essential features of an object.
# It’s implemented through abstract classes and methods, which are designed to be inherited and not instantiated directly.


from abc import ABC, abstractmethod

class Animal(ABC):  # Abstract class
    @abstractmethod
    def sound(self):
        pass

class Dog(Animal):
    def sound(self):
        print("Bark!")

class Cat(Animal):
    def sound(self):
        print("Meow!")

# Cannot instantiate abstract class
# animal = Animal()  # This will raise an error

dog = Dog()
dog.sound()  # Output: Bark!






# Composition
# Composition is when one class contains an object of another class as a member. This allows building complex types by combining objects from other classes.


class Engine:
    def start(self):
        print("Engine started")

class Car:
    def __init__(self, make, model):
        self.make = make
        self.model = model
        self.engine = Engine()  # Composition: Car has an Engine

    def start(self):
        self.engine.start()
        print(f"{self.make} {self.model} is now running.")

car = Car("Honda", "Civic")
car.start()
























list1 = [2,3,4,5]

d = [num *2 for num in list1]
dd = list(map(lambda num: num *2, list1))


print(dd)