import java.sql.Time;
import java.util.Date;

abstract public class File {
    protected String name;
    protected Time createTime;
    protected int size;
    protected String content;
    protected String position;

    public abstract void open();
}
