package package1;

import java.util.Scanner;

public class arr_sort {
    public static void sort(int[] arr,int l,int r){
        if(l>r) return;
        int flag=arr[l],i=l,j=r;
        while (i!=j){
            while (arr[j]>=flag&&i<j){
                j--;
            }
            while (arr[i]<=flag&&i<j){
                i++;
            }
            if(i<j){
                int tmp=arr[i];
                arr[i]=arr[j];
                arr[j]=tmp;
            }
        }
        arr[l]=arr[i];
        arr[i]=flag;
        sort(arr,l,i-1);
        sort(arr,i+1,r);
    }

    public static int[] qsort(int[] arr){
        if(arr==null) return null;
        if(arr.length==1) return arr;
        sort(arr,0,arr.length- 1);
        return arr;
    }

    public static boolean lower_bound(int[] arr,int x){
        if(arr == null) return false;
        int l=0,r=arr.length-1;
        while (l<r){
            int mid=(l+r+1)>>1;
            if(arr[mid]<=x) l=mid;
            else r=mid-1;
        }
        return arr[l] == x;
    }

    public static void main(String[] args) {
        int arr[]={12,45,67,89,123,-45,67};
        qsort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        Scanner scanner=new Scanner(System.in);
        int x=scanner.nextInt();
        System.out.print(lower_bound(arr,x));
    }
}
