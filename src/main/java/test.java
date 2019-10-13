import hibernate.entities.Currency;
import hibernate.entities.UserType;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import static hibernate.MyCRUD.getSf;

public class test {
    private static Session session;
    public static void main(String[] args) {
        Field[] methods = Currency.class.getDeclaredFields();
        for(Field m : methods) {
            System.out.println(m.getName()+ " " + test.class.getName());
        }
    }
}
