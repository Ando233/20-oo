import java.util.Scanner;

public class testNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        num_string numstring = new num_string(num);
        if(numstring.no_pre0()){
            System.out.println("No Pre0!");
            if(numstring.is_palindrome()){
                System.out.println("Is palindrome!");
            }
            else System.out.println("Not palindrome");
        }
    }

}
