package package1;

import java.util.Scanner;

public class Test {
    public static void main(String args[]){
        System.out.print("20373221 王宇奇\n");

        while (true){
            Scanner scanner = new Scanner(System.in);
            String words = scanner.nextLine();
            if(words.equals("Quit")) break;
            else System.out.println("Hello World");
        }
        System.out.println("----- Good Bye! -----");
    }
}
