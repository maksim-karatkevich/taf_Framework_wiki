import com.epam.taf.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Maksim_Karatkevich on 7/27/2016.
 */
public class Main {
    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
//        User us = (User) ctx.getBean("usr");
//        System.out.println(us.toString());
        char c ='1';
        char d = '2';
        int i  = c + d;
        System.out.println(i);
    }
}


