import java.util.HashMap;
import java.util.TreeMap;

public class Check {
    private boolean checkTrainId(String trainId){
        char type = trainId.charAt(0);
        if(type != 'G' && type != 'K' && type != '0'){
            System.out.println("Train serial illegal");
            return false;
        }
        for(int i = 1; i < 4; i++){
            if(!Character.isDigit(trainId.charAt(i))){
                System.out.println("Train serial illegal");
                return false;
            }
        }
        return true;
    }

    public static int checkSeat(String trainId, String seat){
        if(trainId.charAt(0) == '0'){
            if(seat.equals("CC")) return 1;
            else if(seat.equals("SB")) return 2;
            else if(seat.equals("GG")) return 3;
            else return -1;
        }
        else if(trainId.charAt(0) == 'G'){
            if(seat.equals("SC")) return 1;
            else if(seat.equals("HC")) return 2;
            else if(seat.equals("SB")) return 3;
            else return -1;
        }
        else if(trainId.charAt(0) == 'K'){
            if(seat.equals("1A")) return 1;
            else if(seat.equals("2A")) return 2;
            else return -1;
        }
        else return -1;
    }

    private boolean checkPositive(String str){
        for(int j = 0; j < str.length(); j++){
            if(!Character.isDigit(str.charAt(j))){
                return false;
            }
        }
        return true;
    }

    public boolean checkUserId(String code){
        boolean lenerr = false;
        boolean zoneerr = false;
        boolean specerr = false;
        boolean objerr = false;
        boolean sexerr = false;

        if(code.length() != 12) lenerr = true;
        String zonecode = code.substring(0, 4);
        String specicode = code.substring(4, 8);
        String objectcode = code.substring(8, 12);
        String objectcode_2 = code.substring(8, 11);
        int zone = Integer.parseInt(zonecode);
        int spec = Integer.parseInt(specicode);
        int obj = Integer.parseInt(objectcode_2);
        if(zone < 1 || zone > 1237) zoneerr = true;
        else if(spec < 20 || spec > 460) specerr = true;
        else if(obj < 0 || obj > 100) objerr = true;

        if (lenerr||zoneerr||specerr||objerr){
            return false;
        }
        return true;
    }
    public boolean checkAddUser(String ...args){
        if(args.length != 4){
            System.out.println("Arguments illegal");
            return false;
        }
        String name = args[1];
        String sex = args[2];
        String code = args[3];

        boolean sexerr = false;
        HashMap<String,User> Users = User.getUsers();

        char sx = code.charAt(code.length()-1);
        if(sex.equals("F") && sx != '0') sexerr = true;
        else if(sex.equals("M") && sx != '1') sexerr = true;
        else if(sex.equals("O") && sx != '2') sexerr = true;

        if(!name.matches("^[A-Z_a-z]+$")){
            System.out.println("Name illegal");
            return false;
        }
        else if(!sex.equals("F")&&!sex.equals("M")&&!sex.equals("O")){
            System.out.println("Sex illegal");
            return false;
        }
        else if (!checkUserId(code)||sexerr){
            System.out.println("Aadhaar number illegal");
            return false;
        }
        else if(Users.containsKey(code)){
            System.out.println("Aadhaar number exist");
            return false;
        }
        else return true;
    }
    public boolean checkTuna(int userMode, String ...args){
        if (userMode == 1) {
            System.out.println("WanNiBa");
            return false;
        }
        return true;
    }

    public boolean checkNut(int userMode, String ...args){
        if(userMode == 0){
            System.out.println("WanNiBa");
            return false;
        }
        return true;
    }

    public boolean checkAddLine(int userMode, String ...args){
        if(userMode == 0){
            System.out.println("Command does not exist");
            return false;
        }
        int len = args.length;
        if(len < 3 || len % 2 == 0){
            System.out.println("Arguments illegal");
            return false;
        }
        for(int i = 4; i < len; i+=2){
            if(!checkPositive(args[i])){
                System.out.println("Arguments illegal");
                return false;
            }
        }
        return true;
    }
    public boolean checkDelLine(int userMode, String ...args){
        if(userMode == 0){
            System.out.println("Command does not exist");
            return false;
        }
        int len = args.length;
        if(len != 2){
            System.out.println("Arguments illegal");
            return false;
        }
        return true;
    }
    public boolean checkAddStation(int userMode, String ...args){
        if(userMode == 0){
            System.out.println("Command does not exist");
            return false;
        }
        int len = args.length;
        if(len != 4) {
            System.out.println("Arguments illegal");
            return false;
        }
        return true;
    }
    public boolean checkDelStation(int userMode, String ...args){
        if(userMode == 0){
            System.out.println("Command does not exist");
            return false;
        }
        int len = args.length;
        if(len != 3) {
            System.out.println("Arguments illegal");
            return false;
        }
        return true;
    }
    public boolean checkLineInfo(String ...args){
        int len = args.length;
        if(len != 2) {
            System.out.println("Arguments illegal");
            return false;
        }
        return true;
    }
    public boolean checkListLine(String ...args){
        int len = args.length;
        if(len != 1) {
            System.out.println("Arguments illegal");
            return false;
        }
        return true;
    }
    public boolean checkAddTrain(int userMode, String ...args){
        if(userMode == 0){
            System.out.println("Command does not exist");
            return false;
        }
        String id = args[1];
        int len = args.length;
        char type = id.charAt(0);
        if(len != 9 && len != 7){
            System.out.println("Arguments illegal");
            return false;
        }
        if((type == 'G' || type == '0') && len != 9){
            System.out.println("Arguments illegal");
            return false;
        }
        if(type == 'K' && len != 7){
            System.out.println("Arguments illegal");
            return false;
        }
        if(!checkTrainId(args[1])) return false;
        return true;
    }
    public boolean checkDelTrain(int userMode, String ...args){
        if(userMode == 0){
            System.out.println("Command does not exist");
            return false;
        }
        int len = args.length;
        if(len != 2) {
            System.out.println("Arguments illegal");
            return false;
        }
        if(!checkTrainId(args[1])) return false;
        return true;
    }
    public boolean checkCheckTicket(int userMode, String ...args){
        if(userMode == 1){
            System.out.println("Command does not exist");
            return false;
        }
        int len = args.length;
        if(len != 5) {
            System.out.println("Arguments illegal");
            return false;
        }
        if(!checkTrainId(args[1])) return false;
        return true;
    }
    public boolean checkListTrain(String ...args){
        int len = args.length;
        if(len != 2 && len != 1) {
            System.out.println("Arguments illegal");
            return false;
        }
        return true;
    }
    public boolean checkLogin(String ...args){
        int len = args.length;
        if(len != 3) {
            System.out.println("Arguments illegal");
            return false;
        }
        return true;
    }
    public boolean checkLogout(String ...args){
        int len = args.length;
        if(len != 1) {
            System.out.println("Arguments illegal");
            return false;
        }
        return true;
    }
    public boolean checkBuyTicket(String ...args){
        int len = args.length;
        int state = User.getState();
        TreeMap<String, Train> trains = Management.getTrains();
        if(len != 6) {
            System.out.println("Arguments illegal");
            return false;
        }

        String trainId = args[1];
        String from = args[2];
        String to = args[3];
        if(state == 0){
            System.out.println("Please login first");
            return false;
        }
        if(!trains.containsKey(trainId)){
            System.out.println("Train does not exist");
            return false;
        }
        Train train = Management.getTrains().get(trainId);
        String lineId = train.getLineId();
        Line line = Management.getLines().get(lineId);
        if(!line.checkLineStations(from) || !line.checkLineStations(to)){
            System.out.println("Station does not exist");
            return false;
        }

        String seat = args[4];
        if(checkSeat(trainId, seat) == -1){
            System.out.println("Seat does not match");
            return false;
        }

        String num = args[5];
        if(!checkPositive(num) || num.equals("0")){
            System.out.println("Ticket number illegal");
            return false;
        }

        if(Integer.parseInt(num) > train.getNums()[checkSeat(trainId, seat)]){
            System.out.println("Ticket does not enough");
            return false;
        }
        return true;
    }

    public boolean checkListOrder(String ...args){
        int len = args.length;
        int state = User.getState();
        if(len != 1) {
            System.out.println("Arguments illegal");
            return false;
        }
        if(state == 0){
            System.out.println("Please login first");
            return false;
        }
        return true;
    }
}
