package hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Persistence;

public class MyCRUD {

    public final String PROPERTIES_FILE_PATH = "src/main/java/hibernate/resources/hibernate.properties";

    private static SessionFactory sf;
    private static Session session;


    public void performCRUDOperation(int operation, Persistence object, Session session) {


        try {
            sf = new Configuration().configure().buildSessionFactory();
            session = sf.openSession();

            switch (operation) {
                case 1: // create:
                    System.out.println(operation + " - create");
                    break;
                case 2: //read
                    System.out.println(operation + " - read");
                    break;
                case 3: //update
                    System.out.println(operation + " - update");
                    break;
                case 4: //delete
                    System.out.println(operation + " - delete");
                    break;
                default:
                    System.out.println(MyCRUD.class.getName() + ".performCRUDOperation() --> \""+ operation +"\" is not a valid CRUD operation.");
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }  finally {
            if(session.isOpen()){
                session.close();
            }
        }


    }


}
