import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String argStr;
        String[] str;
        while (true) {
            argStr = in.nextLine();
            if(argStr.equals("QUIT")){
                System.out.print("----- Good Bye! -----");
                break;
            }
            str = argStr.split(" ");
            var user = new User();
            user.addUser(str);
        }
    }
}
