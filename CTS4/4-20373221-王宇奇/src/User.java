import java.util.ArrayList;
import java.util.HashMap;

public class User {
    public String name = "";
    public String sex = "";
    public String code = "";
    public float money = 0;
    public static String nowUserId = "";
    private static int state = 0;
    public static HashMap<String,User> Users = new HashMap<>();
    public ArrayList<Order> Orders = new ArrayList<>();

    public User(){}
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
        float price = train.getPrices()[idx]*distance;
        user.getOrders().add(new Order(trainId, from, to, seat, num, price));

        System.out.println("Thanks for your order");
    }

    public static void listOrder(){
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
            System.out.print(" num:" + now.num);
            System.out.print(" price:" + String.format("%.2f", now.getPrice() * now.num));
            if(now.pay) System.out.println(" paid:T");
            else System.out.println(" paid:F");
        }
    }

    public static void rechargeBalance(String ...args){
        User user = Users.get(nowUserId);
        float num = Float.parseFloat(args[1]);
        user.money += num;
        System.out.println("Recharge Success");
    }

    public static void checkBalance(){
        User user = Users.get(nowUserId);
        System.out.println("UserName:" + user.name);
        System.out.println("Balance:" + String.format("%.2f", user.money));
    }

    public static void cancelOrder(String ...args){
        String tarTrain = args[1];
        String tarFrom = args[2];
        String tarTo = args[3];
        String tarSeat = args[4];
        int tarNum = Integer.parseInt(args[5]);

        boolean isfind  = false;
        User user = Users.get(nowUserId);
        ArrayList<Order> Orders = user.Orders;
        for(int i = Orders.size()-1; i >= 0; i--){
            Order order = Orders.get(i);
            String trainId = order.getTrainId();
            String from = order.getFrom();
            String to = order.getTo();
            String seat = order.getSeat();
            if(trainId.equals(tarTrain) && from.equals(tarFrom) && to.equals(tarTo) && seat.equals(tarSeat)){
                isfind = true;
                int num = order.num;
                if(num >= tarNum && !order.pay){
                    order.num -= tarNum;
                    Train train = Management.getTrains().get(trainId);
                    int idx = Check.checkSeat(trainId, seat);
                    train.getNums()[idx] += tarNum;
                    if(order.num == 0){
                        Orders.remove(order);
                    }
                    System.out.println("Cancel success");
                    return;
                }
            }
        }
        if(!isfind) System.out.println("No such Record");
        else System.out.println("No enough orders");
    }

    public static void payOrder(){
        User user = Users.get(nowUserId);
        ArrayList<Order> Orders = user.Orders;
        if(user.Orders.isEmpty()){
            System.out.println("No order");
            return;
        }
        float sum = 0;
        if(user instanceof Student){
            int discount = ((Student) user).discount;
            int tmpDiscount = discount;
            for(int i = Orders.size() - 1; i >= 0; i--) {
                Order order = Orders.get(i);
                if(!order.pay) {
                    if (tmpDiscount >= order.num) {
                        sum += order.getPrice() * order.num * 0.05;
                        tmpDiscount -= order.num;
                    }
                    else {
                        sum += order.getPrice() * 0.05 * tmpDiscount;
                        sum += order.getPrice() * (order.num - tmpDiscount);
                        tmpDiscount = 0;
                    }
                }
            }
            if(sum > user.money){
                System.out.println("Balance does not enough");
                return;
            }
            else{
                for(int i = Orders.size() - 1; i >= 0; i--) {
                    Order order = Orders.get(i);
                    if(!order.pay) {
                        if (discount >= order.num) {
                            user.money -= order.getPrice() * order.num * 0.05;
                            discount -= order.num;
                        }
                        else {
                            user.money -= order.getPrice() * 0.05 * discount;
                            user.money -= order.getPrice() * (order.num - discount);
                            discount = 0;
                        }
                    }
                    order.pay = true;
                }
            }
        }
        else{
            for(int i = Orders.size() - 1; i >= 0; i--) {
                Order order = Orders.get(i);
                if(!order.pay) {
                    sum += order.getPrice() * order.num;
                }
            }
            if(sum > user.money){
                System.out.println("Balance does not enough");
                return;
            }
            else{
                for(int i = Orders.size() - 1; i >= 0; i--) {
                    Order order = Orders.get(i);
                    if(!order.pay) {
                        user.money -= order.getPrice() * order.num;
                    }
                    order.pay = true;
                }
            }
        }
        System.out.println("Payment success");
    }
}
