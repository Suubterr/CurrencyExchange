package tools;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySessionFactory {
    private static SessionFactory sf;

    public SessionFactory getSf() {
        return sf;
    }

    public void setSf(SessionFactory sf, String propFile) {
        MyProperties properties = new MyProperties();
        Configuration config = new Configuration();

        properties.setMyProperties(propFile);
        config.addProperties(properties.getDbConProp());
        sf = config.buildSessionFactory();

        this.sf = sf;
    }
}
