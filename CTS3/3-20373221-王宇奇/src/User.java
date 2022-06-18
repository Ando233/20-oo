import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private String name = "";
    private String sex = "";
    private String code = "";
    private static String nowUserId = "";
    private static int state = 0;
    private static HashMap<String,User> Users = new HashMap<>();
    private ArrayList<Order> Orders = new ArrayList<>();

    public User(String name, String sex, String code) {
        this.name = name;
        this.sex = sex;
        this.code = code;
    }

    public static int getState() {
        return state;
    }

    public ArrayList<Order> getOrders() {
        return Orders;
    }

    public static HashMap<String, User> getUsers() {
        return Users;
    }

    public static void addUser(String ...args){
        String name = args[1];
        String sex = args[2];
        String code = args[3];
        Users.put(code, new User(name, sex, code));
        System.out.println("Name:" + name);
        System.out.println("Sex:" + sex);
        System.out.println("Aadhaar:" + code);
    }

    public static void login(String ...args){
        String code = args[1];
        String name = args[2];
        if(state == 1){
            System.out.println("You have logged in");
            return ;
        }
        if(!Users.containsKey(code)){
            System.out.println("User does not exist");
            return ;
        }
        User user = Users.get(code);
        if(!user.name.equals(name)){
            System.out.println("Wrong name");
            return ;
        }
        state = 1;
        nowUserId = code;
        System.out.println("Login success");
    }

    public static void logout(){
        if(state == 0){
            System.out.println("No user has logged in");
            return ;
        }
        state = 0;
        nowUserId = "";
        System.out.println("Logout success");
    }

    public static void buyTicket(String ...args){
        User user = Users.get(nowUserId);
        String trainId = args[1];
        Train train = Management.getTrains().get(trainId);
        String from = args[2];
        String to = args[3];
        String seat = args[4];
        String nums = args[5];
        int num = Integer.parseInt(nums);

        int idx = Check.checkSeat(trainId, seat);
        train.getNums()[idx] -= num;
        int distance = Management.calDistance(from, to);
        float price = train.getPrices()[idx]*distance*num;
        user.getOrders().add(new Order(trainId, from, to, seat, num, price));

        System.out.println("Thanks for your order");
    }

    public static void listOrder(String ...args){
        User user = Users.get(nowUserId);
        if(user.Orders.isEmpty()){
            System.out.println("No order");
            return ;
        }
        for(int i = user.Orders.size()-1; i >= 0; i--){
            Order now = user.Orders.get(i);
            System.out.print("[" + now.getTrainId());
            System.out.print(": " + now.getFrom());
            System.out.print("->" + now.getTo());
            System.out.print("] seat:" + now.getSeat());
            System.out.print(" num:" + now.getNum());
            System.out.println(" price:" + String.format("%.2f", now.getPrice()));
        }
    }
}
