import java.util.*;

public class Line {
    private String id;
    private int nowCap;
    private int maxCap;
    private TreeMap<String, Integer> stations = new TreeMap<>();
    private TreeMap<String, Train> trains = new TreeMap<>();

    public void setId(String id) {
        this.id = id;
    }

    public void setNowCap(int nowCap) {
        this.nowCap = nowCap;
    }

    public void setMaxCap(int maxCap) {
        this.maxCap = maxCap;
    }

    public void setStations(TreeMap<String, Integer> stations) {
        this.stations = stations;
    }

    public int getNowCap() {
        return nowCap;
    }

    public TreeMap<String, Train> getTrains() {
        return trains;
    }

    public TreeMap<String, Integer> getStations() {
        return stations;
    }

    public int getMaxCap() {
        return maxCap;
    }

    public void addStation(String name, String dis){
        if(this.stations.containsKey(name)){
            System.out.println("Station duplicate");
            return ;
        }
        for(int i = 0; i < dis.length(); i++){
            if(!Character.isDigit(dis.charAt(i))) {
                System.out.println("Arguments illegal");
                return;
            }
        }
        
        int stationDis = Integer.parseInt(dis);
        this.stations.put(name, stationDis);

        System.out.println("Add Station success");
    }

    public void delStation(String name){
        if(!stations.containsKey(name)){
            System.out.println("Station does not exist");
            return ;
        }

        this.stations.remove(name);
        System.out.println("Delete Station success");
    }

    public boolean checkLineStations(String name){
        for(Map.Entry<String, Integer> e : stations.entrySet()){
            if(e.getKey().equals(name)){
                return true;
            }
        }
        return false;
    }

    public void addTrain(String trainId, Train train){
        nowCap++;
        trains.put(trainId, train);
    }

    public void delTrain(String trainId){
        nowCap--;
        trains.remove(trainId);
    }

    public void printInfo(){
        System.out.print(id + " ");
        System.out.print(nowCap + "/" + maxCap + " ");

        List<Map.Entry<String, Integer>> stationList = new ArrayList<Map.Entry<String, Integer>>(stations.entrySet());
        Collections.sort(stationList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for(Map.Entry<String, Integer> e : stationList){
            System.out.print(e.getKey() + ":" + e.getValue() + " ");
        }
        System.out.println("");
    }
    public void printTrainInfo(){
        int now = 1;
        for(Map.Entry<String, Train> e : trains.entrySet()){
            if(e.getKey().charAt(0) == 'K'){
                System.out.print("[" + now + "] ");
                e.getValue().printInfo();
                now++;
            }
        }
        for(Map.Entry<String, Train> e : trains.entrySet()){
            if(e.getKey().charAt(0) == 'G'){
                System.out.print("[" + now + "] ");
                e.getValue().printInfo();
                now++;
            }
        }
        for(Map.Entry<String, Train> e : trains.entrySet()){
            if(e.getKey().charAt(0) == '0'){
                System.out.print("[" + now + "] ");
                e.getValue().printInfo();
                now++;
            }
        }
    }
}
