//In this code i have implemented abstract Factory pattern
interface VehicleFactory {
    Vehicle createVehicle();
}

//creating concrete factory for Tata cars
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