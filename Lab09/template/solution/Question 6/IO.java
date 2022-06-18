import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

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

    public static void copyFile (String sourceFile, String targetFile) throws IOException{
        File a = new File(sourceFile);
        File b = new File(targetFile);
        Files.copy(a.toPath(), b.toPath());
    }

    public static void copyDirectiory(String sourceDir, String targetDir) throws IOException{
        File sourceFile = new File(sourceDir);
        File targetFile = new File(targetDir);

        if(!targetFile.exists()) targetFile.mkdirs();

        File[] files = sourceFile.listFiles();
        if(files == null || files.length == 0)	return;

        for(File file : files){
            String movePath = targetFile + File.separator + file.getName();
            if(file.isDirectory()) copyDirectiory(file.getAbsolutePath(), movePath);
            else copyFile(file.getAbsolutePath(), movePath);
        }
    }
}
