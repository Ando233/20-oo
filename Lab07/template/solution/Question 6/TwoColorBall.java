import java.util.HashMap;
import java.util.Map;

public class TwoColorBall {
    public static void main(String[] args) {
        /*
        Your code here
         */
        HashMap<Integer,Boolean> code = new HashMap<Integer, Boolean>();
        for(int i = 0; i < 6; i++){
            int red = (int)(1 + Math.random()*33);
            while (code.containsKey(red)){
                red = (int)(1 + Math.random()*33);
            }
            code.put(red, true);
            System.out.println("红球 " + red);
        }
        int blue = (int)(1 + Math.random()*16);
        System.out.println("蓝球 " + blue);
    }
}