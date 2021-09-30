/* C2 = 0; C3 = 2; C5 = 3; C7 = 6
O1 (+); O2 (+); C = 2; type i/j - double
 */

package Lab1;

public class Lab1 {
    public static void main(String[] args) {

        double s = 0;
        double m = 3;
        double n = 3;
        double a = 1;
        double b = 2;
        double c = 2;

        if (n < a || m < b || (a <= -c && n >= -c)) {
            System.out.println("Error");
            System.exit(1);
        } else {
            for (double i = a; i <= n; i++) {
                for (double j = b; j <= m; j++) {
                    s = s + (i + j) / (i + c);
                }
            }
            System.out.println("S = " + s);
        }

    }
}