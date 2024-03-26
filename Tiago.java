//concrete product for model Tiago
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