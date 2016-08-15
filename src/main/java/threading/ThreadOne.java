package threading;

/**
 * Created by Maksim_Karatkevich on 8/15/2016.
 */
public class ThreadOne extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Static.incr();
        }
    }
}
