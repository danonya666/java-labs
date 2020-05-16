import sync.U1901Bank;
import sync.U1901Thread;

public class SixMain {
    public static void main(String[] argc) {
        U1901Bank bankMain = new U1901Bank();
        U1901Thread threadOne = new U1901Thread(bankMain, 100, 2000);
        threadOne.setName("understandable thread name(first)");
        threadOne.setPriority(Thread.MAX_PRIORITY);
        threadOne.start();

        U1901Thread threadTwo = new U1901Thread(bankMain, 50, 300);
        threadTwo.setName("understandable thread name(second)");
        threadTwo.setPriority(Thread.MAX_PRIORITY);
        threadTwo.start();
    }
}
