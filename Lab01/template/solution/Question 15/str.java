package package1;

public class str{
    public static String strscat(String... args){
        String ans="";
        for(int i=0;i<args.length;i++){
            ans=ans+args[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.print(strscat("a", "b", "c", "", "e"));
    }
}
