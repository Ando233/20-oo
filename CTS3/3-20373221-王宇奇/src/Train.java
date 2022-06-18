public class Train {
    private String trainId;
    private String lineId;
    private float[] prices = new float[5];
    private int[] nums = new int[5];

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public void setPrices(float[] prices) {
        this.prices = prices;
    }

    public void setNums(int[] nums) {
        this.nums = nums;
    }

    public String getTrainId() {
        return trainId;
    }

    public String getLineId() {
        return lineId;
    }

    public float[] getPrices() {
        return prices;
    }

    public int[] getNums() {
        return nums;
    }

    public void printInfo(){
        System.out.print(trainId + ": ");
        System.out.print(lineId + " ");
        if(trainId.charAt(0) == '0'){
            System.out.print("[CC]" + String.format("%.2f",prices[1]) + ":" + nums[1] + " ");
            System.out.print("[SB]" + String.format("%.2f",prices[2]) + ":" + nums[2] + " ");
            System.out.print("[GG]" + String.format("%.2f",prices[3]) + ":" + nums[3] + " ");
        }
        else if(trainId.charAt(0) == 'G'){
            System.out.print("[SC]" + String.format("%.2f",prices[1]) + ":" + nums[1] + " ");
            System.out.print("[HC]" + String.format("%.2f",prices[2]) + ":" + nums[2] + " ");
            System.out.print("[SB]" + String.format("%.2f",prices[3]) + ":" + nums[3] + " ");
        }
        else if(trainId.charAt(0) == 'K'){
            System.out.print("[1A]" + String.format("%.2f",prices[1]) + ":" + nums[1] + " ");
            System.out.print("[2A]" + String.format("%.2f",prices[2]) + ":" + nums[2] + " ");
        }
        System.out.println("");
    }
}
