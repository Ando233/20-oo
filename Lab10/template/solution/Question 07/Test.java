public class Test {
    public static void main(String[] args) throws InterruptedException{
        Object a=new Object();

        ThreadNum threadA=new ThreadNum(a);
        ThreadCha threadB=new ThreadCha(a);
        new Thread(threadA).start();
        Thread.sleep(100);
        new Thread(threadB).start();
        Thread.sleep(100);
    }
}

class ThreadNum implements Runnable{
    private Object a;
    public ThreadNum(Object a){
        this.a = a;
    }

    @Override
    public void run() {
        synchronized (a) {
            for (var i = 1; i <= 52; i += 2) {
                System.out.print(i);
                System.out.print(i + 1);
                a.notify();
                try{
                    a.wait();
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

class ThreadCha implements Runnable{
    private Object a;
    public ThreadCha(Object a){
        this.a = a;
    }

    @Override
    public void run(){
        synchronized (a) {
            for (var i = 'A'; i <= 'Z'; i ++) {
                System.out.print(i);
                if(i != 'Z') System.out.print(' ');
                a.notify();
                try{
                    a.wait();
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}