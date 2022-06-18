public class Student extends User{
    public int discount;

    public Student(String name, String sex, String code, int discount) {
        this.name = name;
        this.sex = sex;
        this.code = code;
        this.discount = discount;
    }

    public static void addUser(String ...args){
        String name = args[1];
        String sex = args[2];
        String code = args[3];
        int discount = Integer.parseInt(args[4]);
        Users.put(code, new Student(name, sex, code, discount));
        System.out.println("Name:" + name);
        System.out.println("Sex:" + sex);
        System.out.println("Aadhaar:" + code);
        System.out.println("Discount:" + discount);
    }
}
