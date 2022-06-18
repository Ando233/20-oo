public class Order {
    private String trainId;
    private String from;
    private String to;
    private String seat;
    private int num;
    private float price;

    public Order(String trainId, String from, String to, String seat, int num, float price) {
        this.trainId = trainId;
        this.from = from;
        this.to = to;
        this.seat = seat;
        this.num = num;
        this.price = price;
    }

    public String getTrainId() {
        return trainId;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getSeat() {
        return seat;
    }

    public int getNum() {
        return num;
    }

    public float getPrice() {
        return price;
    }
}
