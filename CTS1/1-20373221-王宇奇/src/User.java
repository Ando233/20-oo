import java.util.HashMap;

public class User {
    private String name = "";
    private String sex = "";
    private String zonecode = "";
    private String specicode = "";
    private String objectcode = "";
    private String code = "";
    private static int nums = 0;
    static HashMap<String,Integer> Users = new HashMap<>();

    public String getSpecicode() {
        return specicode;
    }

    public String getZonecode() {
        return zonecode;
    }

    public String getObjectcode() {
        return objectcode;
    }

    public void setSpecicode(String specicode) {
        this.specicode = specicode;
    }

    public void setObjectcode(String objectcode) {
        this.objectcode = objectcode;
    }

    public void setZonecode(String zonecode) {
        this.zonecode = zonecode;
    }

    public int addUser(String ...args){
        if(args.length != 4){
            System.out.println("Arguments illegal");
            return -1;
        }

        String name = args[1];
        String sex = args[2];
        String code = args[3];
        boolean lenerr = false;
        boolean zoneerr = false;
        boolean specerr = false;
        boolean objerr = false;
        boolean sexerr = false;

        if(code.length() != 12) lenerr = true;
        else {
            String zonecode = code.substring(0, 4);
            String specicode = code.substring(4, 8);
            String objectcode = code.substring(8, 12);
            String objectcode_2 = code.substring(8, 11);
            int zone = Integer.parseInt(zonecode);
            int spec = Integer.parseInt(specicode);
            int obj = Integer.parseInt(objectcode_2);
            if(zone < 1 || zone > 1237) zoneerr = true;
            else if(spec < 20 || spec > 460) specerr = true;
            else if(obj < 0 || obj > 100) specerr = true;

            char sx = objectcode.charAt(objectcode.length()-1);
            if(sex.equals("F") && sx != '0') sexerr = true;
            else if(sex.equals("M") && sx != '1') sexerr = true;
            else if(sex.equals("O") && sx != '2') sexerr = true;
        }

        if(!name.matches("^[A-Z_a-z]+$")){
            System.out.println("Name illegal");
            return -1;
        }
        else if(!sex.equals("F")&&!sex.equals("M")&&!sex.equals("O")){
            System.out.println("Sex illegal");
            return -1;
        }
        else if (lenerr||zoneerr||specerr||objerr||sexerr){
            System.out.println("Aadhaar number illegal");
            return -1;
        }
        else if(Users.containsKey(code)){
            System.out.println("Aadhaar number exist");
            return -1;
        }
        else{
            nums++;
            Users.put(code, nums);
            System.out.println("Name:" + name);
            System.out.println("Sex:" + sex);
            System.out.println("Aadhaar:" + code);
        }
        return 0;
    }
}
