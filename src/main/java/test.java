
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tools.MyProperties;

public class test {
    public static void main(String[] args) {
        MyProperties dbProp = new MyProperties();
        Configuration dbConfig = new Configuration();
        SessionFactory sf;

        dbProp.setMyProperties("src/main/java/resources/hibernate.properties");
        dbConfig.addProperties(dbProp.getDbConProp());
        sf = dbConfig.buildSessionFactory();
        Session session = sf.openSession();

        if(session.isOpen()){
            System.out.println("Session is open.");
            System.out.println(session.getProperties().toString());
            sf.close();
        }

    }


}
