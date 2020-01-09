package ovn2;
import java.util.Scanner;
public class P34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
int n = scan.nextInt();
double x = 1;
n = scan.nextInt();
for(int i = 0; i <= n; i++) {
	x = x * n;
	double medelValue = x / (double) n;
	System.out.println(medelValue);
}

	}

}
