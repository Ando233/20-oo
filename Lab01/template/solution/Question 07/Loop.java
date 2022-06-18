package package1;

import java.util.Scanner;

public class Loop {
    public static void main (String args[ ]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1; i <= n*n; i++){
            System.out.print(i + " ");
            if(i%n == 0) System.out.println();
        }
    }
}
