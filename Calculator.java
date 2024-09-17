public class Calculator {
    public static void main(String args[]) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        SimpleMath Math = new SimpleMath();
        System.out.println("PI = " + Math.PI);
        System.out.println("e = " + Math.e);
        System.out.println("a+b=" + Math.add(a, b));
        System.out.println("a-b=" + Math.substract(a, b));

    }
}