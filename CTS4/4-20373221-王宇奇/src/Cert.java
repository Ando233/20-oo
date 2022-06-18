import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Cert {
    static int pos = 0;
    static int neg = 0;
    public static HashMap<String, Boolean> Certs = new HashMap<>();

    public static HashMap<String, Boolean> read(String fileName) throws IOException {
        HashMap<String, Boolean> cert = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            String[] lines = line.split(",");
            cert.put(lines[0], lines[1].equals("P"));
        }
        br.close();
        return cert;
    }

    public static void importCert(String filename) throws IOException {
        int tmppos = 0;
        int tmpneg = 0;
        HashMap<String, Boolean> tmp;
        tmp = Cert.read(filename);
        for(Map.Entry<String, Boolean> e : tmp.entrySet()){
            Certs.put(e.getKey(), e.getValue());
        }
        for(Map.Entry<String, Boolean> e : Certs.entrySet()){
            if(e.getValue() == Boolean.TRUE){
                tmppos++;
            }
            else tmpneg++;
        }
        pos = tmppos;
        neg = tmpneg;
        System.out.println("Import Success, Positive:" + pos + " Negative:" + neg);
    }
}
