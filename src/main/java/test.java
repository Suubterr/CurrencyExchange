import hibernate.MyCRUD;
import hibernate.entities.Currency;
import hibernate.entities.UserType;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import static hibernate.MyCRUD.getSf;

public class test {
    public static void main(String[] args) {
        UserType ut = new UserType();
        ut.setTypeName("Admin");

        MyCRUD crud = new MyCRUD();
        List results = (List)crud.read(ut);
        for(Object result : results) {
            result.toString();
        }
    }
}
