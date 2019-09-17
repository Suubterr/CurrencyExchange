
import hibernate.MyCRUD;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tools.MyProperties;

import javax.persistence.Persistence;

public class test {
    public static void main(String[] args) {
        SessionFactory session = null;
        MyCRUD myCRUD = new MyCRUD();
        myCRUD.performCRUDOperation("lol",session, new Persistence());
    }


}
