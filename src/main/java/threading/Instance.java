package threading;

/**
 * Created by Maksim_Karatkevich on 8/15/2016.
 */
public class Instance {
    private static Instance ourInstance = new Instance();

    public static Instance getInstance() {
        return ourInstance;
    }

    private Instance() {
    }
}
