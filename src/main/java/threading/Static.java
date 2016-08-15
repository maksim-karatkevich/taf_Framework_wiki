package threading;

/**
 * Created by Maksim_Karatkevich on 8/15/2016.
 */
public class Static {
    static int counter = 0;

    static void dec() {
        counter--;
    }

    static void incr() {
        counter++;
    }

    static int getCounter() {
        return counter;
    }

}
