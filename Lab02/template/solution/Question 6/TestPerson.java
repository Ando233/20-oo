public class TestPerson {
    public static void main(String[] args) {
        var Xiaoming = new Person("Xiaoming", 15, 'M');
        Xiaoming.setAge(16);
        int ming_age = Xiaoming.getAge();
        System.out.println(ming_age);

        var Xiaomei = new Person("Xiaomei", 17, 'F');
        Xiaomei.setAge(18);
        int mei_age = Xiaomei.getAge();
        System.out.println(mei_age);
    }
}
