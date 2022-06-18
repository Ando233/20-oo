public class Check {
    private boolean checkTrainId(String trainId){
        String id = trainId;
        char type = id.charAt(0);
        if(type != 'G' && type != 'K' && type != '0'){
            System.out.println("Train serial illegal");
            return false;
        }
        for(int i = 1; i < 4; i++){
            if(!Character.isDigit(id.charAt(i))){
                System.out.println("Train serial illegal");
                return false;
            }
        }
        return true;
    }
    public boolean checkAddUser(String ...args){
        if(args.length != 4){
            System.out.println("Arguments illegal");
            return false;
        }
        return true;
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
            for(int j = 0; j < args[i].length(); j++){
                if(!Character.isDigit(args[i].charAt(j))){
                    System.out.println("Arguments illegal");
                    return false;
                }
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
}
