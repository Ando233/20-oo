package package1;

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
        return ;
    }

    public static int[] qsort(int[] arr){
        if(arr==null) return null;
        if(arr.length==1) return arr;
        sort(arr,0,arr.length- 1);
        return arr;
    }

    public static void main(String[] args) {
        int arr[]={1,5,3,4,8,7,6,2};
        qsort(arr);
        for(int i=0;i<=7;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
