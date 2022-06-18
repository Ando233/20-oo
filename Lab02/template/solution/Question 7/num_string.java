public class num_string {
    private String nums = " ";
    private int len = nums.length();
    public num_string(String nums) {
        this.nums = nums;
    }

    public boolean no_pre0(){
        if(len == 0) return false;
        if(nums.charAt(0) == '0') return false;
        else{
            for(int i = 0;i < len;i++){
                if(nums.charAt(i) > '9'||nums.charAt(i) < '0'){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean is_palindrome(){
        if(len == 0) return false;
        for(int i = 0;i < len;i++){
            if(nums.charAt(i) > '9'||nums.charAt(i) < '0'){
                return false;
            }
        }
        StringBuilder tmp = new StringBuilder(nums);
        String reverse = tmp.reverse().toString();
        if(nums.equals(reverse)){
            return true;
        }
        else return false;
    }
}
