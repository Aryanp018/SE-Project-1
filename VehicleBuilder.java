// implementing builder pattern
class VehicleBuilder {
    public void constructVehicle(VehicleFactory factory, String trim, String paint, String wheels) {
        Vehicle vehicle = factory.createVehicle();
        vehicle.configure(trim, paint, wheels);
        vehicle.displaySpecifications();
    }
}