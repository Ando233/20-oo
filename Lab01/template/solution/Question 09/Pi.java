package package1;

public class Pi {
    public static double getPi(int n){
        double ans=0;
        if(n<0) n=0;
        for(int i=0;i<=n;i++){
            if(i%2==1) ans-=1.0/(2*i+1);
            else ans+=1.0/(2*i+1);
        }
        return 4*ans;
    }
    public static void main(String args[]){
        System.out.print(getPi(10000000));
    }
}
