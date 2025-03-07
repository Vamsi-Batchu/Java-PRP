// 🔹 Abstraction: Abstract class Vehicle
abstract class Vehicle {
    String brand;

    // Constructor
    Vehicle(String brand) {
        this.brand = brand;
    }

    // Abstract Method (Must be implemented by subclasses)
    abstract void displayInfo();

    // Concrete Method
    void startEngine() {
        System.out.println("Engine started for " + brand);
    }
}

// 🔹 Interface: Defines additional behaviors
interface VehicleFeatures {
    void chargeBattery(); // Abstract method (Implemented by ElectricCar)
}

// 🔹 Encapsulation: Class with private attributes & Getters/Setters
class Car extends Vehicle {
    private String model;
    private int year;

    // Constructor
    Car(String brand, String model, int year) {
        super(brand); // Calls the parent class constructor
        this.model = model;
        this.year = year;
    }

    // Encapsulation: Getters & Setters
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Polymorphism: Overriding displayInfo() from Vehicle
    @Override
    void displayInfo() {
        System.out.println("Car Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
}

// 🔹 Inheritance + Polymorphism: ElectricCar extends Car & implements interface
class ElectricCar extends Car implements VehicleFeatures {
    private int batteryLife;

    // Constructor
    ElectricCar(String brand, String model, int year, int batteryLife) {
        super(brand, model, year); // Calls the constructor of Car
        this.batteryLife = batteryLife;
    }

    // Overriding displayInfo() (Polymorphism)
    @Override
    void displayInfo() {
        super.displayInfo(); // Calls the parent method
        System.out.println("Battery Life: " + batteryLife + " hours");
    }

    // Implementing Interface Method
    @Override
    public void chargeBattery() {
        System.out.println("Charging battery for " + getModel());
    }

    // Method Overloading: Different ways to charge battery
    void chargeBattery(int percentage) {
        System.out.println("Charging battery to " + percentage + "%");
    }
}

// 🔹 Main Class
public class OOPExample {
    public static void main(String[] args) {
        // Creating an object of Car
        Car myCar = new Car("Toyota", "Corolla", 2022);
        myCar.displayInfo();
        myCar.startEngine();

        System.out.println();

        // Creating an object of ElectricCar
        ElectricCar myElectricCar = new ElectricCar("Tesla", "Model S", 2023, 12);
        myElectricCar.displayInfo();
        myElectricCar.startEngine();
        myElectricCar.chargeBattery(); // Interface method
        myElectricCar.chargeBattery(80); // Overloaded method
    }
}
