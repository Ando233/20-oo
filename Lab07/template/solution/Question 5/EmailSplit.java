import java.util.HashMap;
import java.util.Map;

public class EmailSplit {
    public static void main(String[] args)
    {
        String str = "aa@sohu.com,bb@163.com,cc@sina.com";
        Map<String, String> emailMap = new HashMap<String, String>();
        /*
        Your code here
         */
        String []a = str.split(",");
        for (int i=0;i<a.length;i++){
            String []b = a[i].split("@");
            emailMap.put(b[0], b[1]);
        }
        System.out.println(emailMap.toString());
    }
}