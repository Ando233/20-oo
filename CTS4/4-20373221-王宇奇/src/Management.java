import java.util.Map;
import java.util.TreeMap;

public class Management {
    private static TreeMap<String, Line> Lines = new TreeMap<>();
    private static TreeMap<String, Train> Trains = new TreeMap<>();

    public static TreeMap<String, Line> getLines() {
        return Lines;
    }

    public static TreeMap<String, Train> getTrains() {
        return Trains;
    }

    public static int checkStations(String name){
        for(Map.Entry<String, Line> e : Lines.entrySet()){
            if(e.getValue().getStations().containsKey(name)){
                return e.getValue().getStations().get(name);
            }
        }
        return -1;
    }

    public void addLine(String ...args){
        String id = args[1];
        int maxCap = Integer.parseInt(args[2]);
        int len = args.length;
        var line = new Line();
        TreeMap<String, Integer> line_stations = new TreeMap<>();
        for(int i = 3; i < len; i+=2){
            if(!line_stations.containsKey(args[i])){
                int dis = Integer.parseInt(args[i+1]);
                line_stations.put(args[i], dis);
            }
            else {
                System.out.println("Station duplicate");
                return ;
            }
        }

        if(Lines.containsKey(id)){
            System.out.println("Line already exists");
            return ;
        }

        if(maxCap <= 0){
            System.out.println("Capacity illegal");
            return ;
        }

        line.setId(id);
        line.setMaxCap(maxCap);
        line.setStations(line_stations);

        Lines.put(id, line);
        System.out.println("Add Line success");
    }
    public void delLine(String ...args){
        String id = args[1];
        if(!Lines.containsKey(id)){
            System.out.println("Line does not exist");
            return;
        }

        Line line = Lines.get(id);
        for(Map.Entry<String, Train> e : line.getTrains().entrySet()){
            Trains.remove(e.getKey());
        }

        Lines.remove(id);
        System.out.println("Del Line success");
    }
    public void addStation(String ...args){
        String id = args[1];
        if(!Lines.containsKey(id)){
            System.out.println("Line does not exist");
            return;
        }

        Line line = Lines.get(id);
        line.addStation(args[2], args[3]);
    }
    public void delStation(String ...args){
        String id = args[1];
        if(!Lines.containsKey(id)){
            System.out.println("Line does not exist");
            return;
        }

        Line line = Lines.get(id);
        line.delStation(args[2]);
    }
    public void lineInfo(String ...args){
        String id = args[1];
        if(!Lines.containsKey(id)){
            System.out.println("Line does not exist");
            return;
        }

        Line line = Lines.get(id);
        line.printInfo();
    }
    public void listLine(){
        if(Lines.isEmpty()){
            System.out.println("No Lines");
            return;
        }

        int now = 1;
        for(Map.Entry<String, Line> e : Lines.entrySet()){
            System.out.print("[" + now + "]" + " ");
            e.getValue().printInfo();
            now++;
        }
    }
    public void addTrain(String ...args){
        String train_id = args[1];
        String line_id = args[2];
        if(Trains.containsKey(train_id)){
            System.out.println("Train serial duplicate");
            return;
        }
        if(!Lines.containsKey(line_id)){
            System.out.println("Line illegal");
            return;
        }
        var line = Lines.get(line_id);
        if(line.getNowCap() == line.getMaxCap()){
            System.out.println("Line illegal");
            return;
        }
        
        float[] prices = new float[5];
        int[] nums = new int[5];
        for(int i = 3; i < args.length; i++){
            if(i % 2 == 1) {
                float price = Float.parseFloat(args[i]);
                if(price < 0){
                    System.out.println("Price illegal");
                    return;
                }
                prices[i / 2] = price;
            }
            else {
                int num = Integer.parseInt(args[i]);
                if(num < 0){
                    System.out.println("Ticket num illegal");
                    return;
                }
                nums[i / 2 - 1] = num;
            }
        }
        var train = new Train();
        train.setTrainId(train_id);
        train.setLineId(line_id);
        train.setPrices(prices);
        train.setNums(nums);

        line.addTrain(train_id, train);

        Trains.put(train_id, train);
        System.out.println("Add Train Success");
    }
    public void delTrain(String ...args){
        String trainId = args[1];
        if(!Trains.containsKey(trainId)){
            System.out.println("Train does not exist");
            return;
        }
        Train train = Trains.get(trainId);
        Line line = Lines.get(train.getLineId());

        line.delTrain(trainId);

        Trains.remove(trainId);
        System.out.println("Del Train Success");
    }
    public static int calDistance(String from, String to){
        int disFrom = checkStations(from);
        int disTo = checkStations(to);
        if(disFrom == -1 || disTo == -1){
            return -1;
        }
        else return disTo - disFrom;
    }
    public void checkTicket(String ...args){
        String trainId = args[1];
        String from = args[2];
        String to = args[3];
        String seat = args[4];
        float price = 0;
        int num = 0;
        if(!Trains.containsKey(trainId)){
            System.out.println("Train serial does not exist");
            return;
        }
        Train train = Trains.get(trainId);
        int distance = calDistance(from, to);
        if(distance == -1){
            System.out.println("Station does not exist");
            return;
        }
        if(Check.checkSeat(trainId, seat) == -1){
            System.out.println("Seat does not match");
            return ;
        }
        price = train.getPrices()[Check.checkSeat(trainId, seat)];
        num = train.getNums()[Check.checkSeat(trainId, seat)];

        float totPrice = price * distance;
        System.out.print("[" + trainId + ": ");
        System.out.print(from + "->" + to + "] ");
        System.out.print("seat:" + seat + " ");
        System.out.print("remain:" + num + " ");
        System.out.print("distance:" + distance + " ");
        System.out.println("price:" + String.format("%.2f", totPrice));
    }
    public void listTrain(String ...args){
        int len = args.length;
        if(len == 1) {
            if(Trains.isEmpty()){
                System.out.println("No Trains");
                return ;
            }
            int now = 1;
            for (Map.Entry<String, Train> e : Trains.entrySet()) {
                if (e.getKey().charAt(0) == 'K') {
                    System.out.print("[" + now + "] ");
                    e.getValue().printInfo();
                    now++;
                }
            }
            for (Map.Entry<String, Train> e : Trains.entrySet()) {
                if (e.getKey().charAt(0) == 'G') {
                    System.out.print("[" + now + "] ");
                    e.getValue().printInfo();
                    now++;
                }
            }
            for (Map.Entry<String, Train> e : Trains.entrySet()) {
                if (e.getKey().charAt(0) == '0') {
                    System.out.print("[" + now + "] ");
                    e.getValue().printInfo();
                    now++;
                }
            }
        }
        else {
            String lineId = args[1];
            if(!Lines.containsKey(lineId)){
                System.out.println("Line does not exist");
                return ;
            }
            Line line = Lines.get(lineId);
            if(line.getNowCap() == 0){
                System.out.println("No Trains");
                return ;
            }
            line.printTrainInfo();
        }
    }
}
