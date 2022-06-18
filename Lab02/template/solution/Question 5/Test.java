public class Test {
    public static void main(String[] args) {
        Music music_1 = new Music("安河桥","民谣");
        Phone phone_1 = new Phone("华为","P400");
        System.out.println("我在用"+phone_1.getName()+phone_1.getType()+"听"+music_1.getType()+"歌曲"+music_1.getName());
    }

}
