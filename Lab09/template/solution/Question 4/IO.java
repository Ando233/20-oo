import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IO {
    public static void removeComments(String inputPath,String outPath) throws IOException {
        FileReader input = new FileReader(inputPath);
        FileWriter output = new FileWriter (outPath);
        int flag = 0;
        char []c = new char [1024];
        String s = "";
        while ((flag = input.read(c)) != -1) {
            s += new String (c, 0, flag);
        }
        input.close();

        String []arr = s.split("\n");

        int mulAnno = 0;
        for (int i = 0;i < arr.length;i++){
            for(int j = 0;j < arr[i].length();j++){
                if(j != arr[i].length() - 1 && mulAnno == 0){
                    if(arr[i].charAt(j) == '/' && arr[i].charAt(j + 1) == '/'){
                        output.write('\n');
                        break;
                    }
                    if(arr[i].charAt(j) == '/' && arr[i].charAt(j + 1) == '*'){
                        mulAnno = 1;
                    }
                }
                else {
                    if(arr[i].charAt(j) == '*' && arr[i].charAt(j + 1) == '/'){
                        mulAnno = 0;
                        j += 2;
                    }
                }
                if(mulAnno == 0) output.write(arr[i].charAt(j));
            }
        }
        output.close();
    }
    public static void addLineNo(String inputPath,String outPath) throws IOException{
        FileReader input = new FileReader(inputPath);
        FileWriter output = new FileWriter (outPath);
        int flag = 0;
        char []c = new char [1024];
        String s = "";
        while ((flag = input.read(c)) != -1) {
            s += new String (c, 0, flag);
        }
        input.close();

        String []arr = s.split("\n");

        for(int i = 0;i < arr.length;i++){
            output.write((i + 1) + ": ");
            output.write(arr[i]);
        }

        output.close();
    }
}
