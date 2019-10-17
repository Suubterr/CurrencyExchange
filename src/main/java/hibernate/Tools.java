package hibernate;

import hibernate.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Tools {

    private static SessionFactory sf;
    private static Session session;

    private static Session setSession() {

        try {
            sf = new Configuration()
                    .addPackage("java.hibernate.entities")
                    .addAnnotatedClass(Currency.class)
                    .addAnnotatedClass(Users.class)
                    .addAnnotatedClass(UserType.class)
                    .addAnnotatedClass(Transactions.class)
                    .configure()
                    .buildSessionFactory();
            session = sf.openSession();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }

    public static Session getSession() {
        return setSession();
    }

    public void closeSession() {
        try{
            if(session.isOpen()) {
                closeSession();
            } else {
                System.out.println(
                        this.getClass().getName()
                                + '.' + this.getClass().getEnclosingMethod().getName()
                                + "Can't close session. None is open.");
            }
        } catch (Exception e) {
            System.out.println(
                    Tools.class.getName()
                        + " || Problem with closing session: "
                        + e.getMessage());
        }
    }
}
