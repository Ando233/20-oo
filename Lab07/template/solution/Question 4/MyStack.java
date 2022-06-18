//MyStack.java
import java.util.LinkedList;

public class MyStack<T> {
    private LinkedList<T> values=new LinkedList<T>();
    public void push(T t){
        //Your code here
        values.add(t);
    }
    public T pull(){
        //Your code here
        T x = values.getLast();
        values.removeLast();
        return x;
    }
    public T peek(){
        //Your code here
        return values.getLast();
    }
    public static void main(String[] args){
        /* Your test code here */
        MyStack test = new MyStack<String>();
        test.push("animal");
        test.push("fruit");
        System.out.println(test.pull());
        test.peek();
        System.out.println(test.peek());
    }

}