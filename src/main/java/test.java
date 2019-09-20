import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tools.MyProperties;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        Configuration cfg = new Configuration();
        MyProperties properties = new MyProperties();
        properties.setMyProperties("src/main/java/resources/hibernate.properties");
        cfg.setProperties(properties.getDbConProp());
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        boolean isConnected = session.isConnected();
        boolean isOpen = session.isOpen();

        if(isConnected) {
            System.out.println("Session in connected");
        }

        if(isOpen) {
            System.out.println("Session is open");
            session.close();
        }
    }
}
