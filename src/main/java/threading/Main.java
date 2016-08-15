package threading;

/**
 * Created by Maksim_Karatkevich on 8/15/2016.
 */
public class Main {
    public static void main(String[] args) {
        ThreadOne threadOne = new ThreadOne();
        threadOne.start();
        for (int i = 0; i < 5; i++) {
            Static.dec();
        }
        System.out.println(Static.getCounter());
    }
}
