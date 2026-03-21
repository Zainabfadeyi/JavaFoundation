import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int product = 0;

        if (a == 0 || b == 0) {
            System.out.println(0);
            return;
        }        
	int sign = 1;
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            sign = -1;
        }


        int absA = Math.abs(a);
        int absB = Math.abs(b);

        for (int i = 0; i < absB; i++) {
            product += absA;
        }

        product *= sign;

        System.out.println(product);
    }
}