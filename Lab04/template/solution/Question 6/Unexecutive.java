public class Unexecutive extends File{
    private boolean isGivenMethod = false;

    @Override
    public void open(){
        if(isGivenMethod){
            System.out.println("Open!");
        }
        else {
            System.out.println("Please give method!");
        }
    }
}
