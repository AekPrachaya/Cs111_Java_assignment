// Prachaya Kheawchan
// 6609681215
class Ball {
    private double radius;

    // Getter and setter for radius
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Method to calculate surface area
    public double getSurface() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    // Method to calculate volume
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }
}
