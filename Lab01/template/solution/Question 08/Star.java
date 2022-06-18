package package1;

import java.util.Scanner;

public class Star {
    public static void main (String args[ ]) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int len=(n+1)/2;
        for(int i=1;i<=len;i++){
            for(int j=1;j<=len-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=(i*2-1);j++){
                System.out.print("*");
            }
            for(int j=1;j<=len-i;j++){
                System.out.print(" ");
            }
            System.out.println("");
        }
        for(int i=len+1;i<=n;i++){
            for(int j=1;j<=i-len;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=(n-i+1)*2-1;j++){
                System.out.print("*");
            }
            for(int j=1;j<=i-len;j++){
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
