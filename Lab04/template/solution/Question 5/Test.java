public class Test {
    public static void main(String[] args) {
        Motorbike mb;
        Person brother = new Person("Brother", null);
        Person sister = new Person("Sister", "不像我，我只会心疼geigei~");
        mb = new Motorbike(2, brother, sister);
        System.out.println(mb);
        sister.say();
    }
}