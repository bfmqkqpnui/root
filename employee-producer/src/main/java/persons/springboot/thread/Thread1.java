package persons.springboot.thread;

/**
 * 用户线程打印
 * ABCABCABCABCABCABCABCABCABCABC
 */
public class Thread1 implements Runnable {

    private String name;
    private String before;
    private String self;

    public Thread1(String name, String before, String self) {
        this.name = name;
        this.before = before;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (before) {
                synchronized (self) {
                    System.out.print(name);
                    count--;

                    self.notify();
                }

                try {
                    before.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        String a = "a";
        String b = "b";
        String c = "c";

        new Thread(new Thread1("A",c,a)).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Thread1("B",a,b)).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Thread1("C",b,c)).start();
    }
}
