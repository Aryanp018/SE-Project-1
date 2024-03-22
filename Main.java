import java.util.Scanner;

// Abstract Factory Pattern
interface VehicleFactory {
    Vehicle createVehicle();
}

// Concrete Factory for Tata vehicles
class TataFactory implements VehicleFactory {
    private String model;

    public TataFactory(String model) {
        this.model = model;
    }

    @Override
    public Vehicle createVehicle() {
        if (model.equalsIgnoreCase("Altroz")) {
            return new Altroz();
        } else if (model.equalsIgnoreCase("Nexon")) {
            return new Nexon();
        } else if (model.equalsIgnoreCase("Tiago")) {
            return new Tiago();
        } else {
            throw new IllegalArgumentException("Invalid Tata car model: " + model);
        }
    }
}

// Product interface
interface Vehicle {
    void configure(String trim, String paint, String wheels);
    void displaySpecifications();
}

// Concrete Products: Tata Car Models
class Altroz implements Vehicle {
    private String trim;
    private String paint;
    private String wheels;

    @Override
    public void configure(String trim, String paint, String wheels) {
        this.trim = trim;
        this.paint = paint;
        this.wheels = wheels;
    }

    @Override
    public void displaySpecifications() {
        System.out.println("Altroz Specifications:");
        System.out.println("Trim: " + trim);
        System.out.println("Paint: " + paint);
        System.out.println("Wheels: " + wheels);
    }
}

class Nexon implements Vehicle {
    private String trim;
    private String paint;
    private String wheels;

    @Override
    public void configure(String trim, String paint, String wheels) {
        this.trim = trim;
        this.paint = paint;
        this.wheels = wheels;
    }

    @Override
    public void displaySpecifications() {
        System.out.println("Nexon Specifications:");
        System.out.println("Trim: " + trim);
        System.out.println("Paint: " + paint);
        System.out.println("Wheels: " + wheels);
    }
}

class Tiago implements Vehicle {
    private String trim;
    private String paint;
    private String wheels;

    @Override
    public void configure(String trim, String paint, String wheels) {
        this.trim = trim;
        this.paint = paint;
        this.wheels = wheels;
    }

    @Override
    public void displaySpecifications() {
        System.out.println("Tiago Specifications:");
        System.out.println("Trim: " + trim);
        System.out.println("Paint: " + paint);
        System.out.println("Wheels: " + wheels);
    }
}

// Builder Pattern: Director
class VehicleBuilder {
    public void constructVehicle(VehicleFactory factory, String trim, String paint, String wheels) {
        Vehicle vehicle = factory.createVehicle();
        vehicle.configure(trim, paint, wheels);
        vehicle.displaySpecifications();
    }
}

// Singleton Pattern: Configuration Manager
class ConfigurationManager {
    private static ConfigurationManager instance;
    private ConfigurationManager() {}

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VehicleBuilder builder = new VehicleBuilder();
        ConfigurationManager configManager = ConfigurationManager.getInstance();

        // Selecting Tata car model
        System.out.println("Select Tata car model (Altroz/Nexon/Tiago):");
        String model = scanner.nextLine();

        // Taking input from user for configuration
        System.out.println("Enter trim (Base/Plus/Premium):");
        String trim = scanner.nextLine();
        System.out.println("Enter paint (White/Black/Silver):");
        String paint = scanner.nextLine();
        System.out.println("Enter wheels (Standard/Alloy/Sport):");
        String wheels = scanner.nextLine();

        // Creating Tata vehicle using Builder pattern
        VehicleFactory factory = new TataFactory(model);
        builder.constructVehicle(factory, trim, paint, wheels);

        scanner.close();
    }
}
