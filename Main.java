import java.util.Scanner;

// In this code i have implemented using abstract factory pattern
interface VehicleFactory {
    Vehicle createVehicle();
}

// creating Concrete Factory for Tata cars
class TataFactory implements VehicleFactory {
    private String model;

    public TataFactory(String model) {
        this.model = model;
    }

    @Override
    // using ignore case reagardless what user types it will not throw an exception
    public Vehicle createVehicle() {
        if (model.equalsIgnoreCase("Altroz")) {
            return new Altroz();
        } else if (model.equalsIgnoreCase("Nexon")) {
            return new Nexon();
        } else if (model.equalsIgnoreCase("Tiago")) {
            return new Tiago();
        } else if (model.equalsIgnoreCase("Harrier")) {
            return new Harrier();
        } else {
            throw new IllegalArgumentException("Invalid Tata car model: " + model);
        }
    }
}

// Creating and interface for product
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
        System.out.println("Following are the specifications selected by you for Altroz:");
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
        System.out.println("Following are the specifications selected by you for Nexon:");
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
        System.out.println("Following are the specifications selected by you for Tiago:");
        System.out.println("Trim: " + trim);
        System.out.println("Paint: " + paint);
        System.out.println("Wheels: " + wheels);
    }
}

class Harrier implements Vehicle {
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
        System.out.println("Following are the specifications selected by you for Harrier:");
        System.out.println("Trim: " + trim);
        System.out.println("Paint: " + paint);
        System.out.println("Wheels: " + wheels);
    }
}

// implementing builder pattern
class VehicleBuilder {
    public void constructVehicle(VehicleFactory factory, String trim, String paint, String wheels) {
        Vehicle vehicle = factory.createVehicle();
        vehicle.configure(trim, paint, wheels);
        vehicle.displaySpecifications();
    }
}

// The following code is for singleton pattern
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
        Scanner scanner = new Scanner(System.in);// using scanner class to take input from the user
        VehicleBuilder builder = new VehicleBuilder();
        ConfigurationManager configManager = ConfigurationManager.getInstance();

        // Selecting which car model user wants
        System.out.println("Select Tata car model (Altroz/Nexon/Tiago/Harrier):");
        String model = scanner.nextLine();

        // Taking configuration for the car from the user as an input
        System.out.println("Enter trim (Base/Plus/Premium/Premium Plus):");
        String trim = scanner.nextLine();
        System.out.println("Enter paint (White/Black/Silver/Grey):");
        String paint = scanner.nextLine();
        System.out.println("Enter wheels (Standard/Alloy/Sport/Steel):");
        String wheels = scanner.nextLine();

        // using builder pattern creating a tata car model
        VehicleFactory factory = new TataFactory(model);
        builder.constructVehicle(factory, trim, paint, wheels);

        scanner.close();
    }
}
