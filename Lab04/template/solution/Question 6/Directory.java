public class Directory extends File{
    private int size;
    private static int directoryNum = 0;
    private static int fileNum = 0;
    private String name;

    public void addFile(String iname){
        fileNum++;
        System.out.println("Add file " + iname + "successfully!");
    }

    public void addDirectory(String iname){
        directoryNum++;
        System.out.println("Add directory " + iname + "successfully!");
    }

    @Override
    public void open() {
        System.out.println("Open " + name + "successfully!");
    }
}
