package sync;

public class U1901Thread extends Thread {
    private U1901Bank bankWork;
    int intTrans;
    long lngSleep;

    public U1901Thread(U1901Bank bankWork, int intTrans, long lngSleep) {
        this.bankWork = bankWork;
        this.intTrans = intTrans;
        this.lngSleep = lngSleep;
    }

    @Override
    public void run() {
        try {
            bankWork.calc(intTrans, lngSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        super.run();
    }
}
