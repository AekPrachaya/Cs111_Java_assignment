// Prachaya Kheawchan
// 6609681215


import java.util.Scanner;
class BallTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Input the radius of the ball > ");
        double radius = scanner.nextDouble();

        // Create Ball object
        Ball ball = new Ball();
        ball.setRadius(radius);

        // Print results with formatted output
        System.out.printf("The ball radius '%.2f' has surface area = %.3f\n", ball.getRadius(), ball.getSurface());
        System.out.printf("The ball radius '%.2f' has volume = %.3f\n", ball.getRadius(), ball.getVolume());
        scanner.close();
    }
}
