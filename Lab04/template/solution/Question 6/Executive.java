public class Executive extends File{
    private String name;

    @Override
    public void open(){
        System.out.println("Open" + name + "successfully!");
    }
}
