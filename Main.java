import java.util.Scanner;

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
        System.out.println("Enter paint (White/Black/Silver/Nardo Grey):");
        String paint = scanner.nextLine();
        System.out.println("Enter wheels (Standard/Alloy/Sport/Steel):");
        String wheels = scanner.nextLine();

        // using builder pattern creating a tata car model
        VehicleFactory factory = new TataFactory(model);
        builder.constructVehicle(factory, trim, paint, wheels);

        scanner.close();
    }
}
