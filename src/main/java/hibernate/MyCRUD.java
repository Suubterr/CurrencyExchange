package hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Persistence;

public class MyCRUD {
    public void performCRUDOperation(String operation, SessionFactory sessionFactory, Persistence object) {


        Session session = null;
        try {
            session = sessionFactory.openSession();

            switch (operation.toLowerCase()) {
                case "create":
                    System.out.println(operation);
                    break;
                case "read":
                    System.out.println(operation);
                    break;
                case "update":
                    System.out.println(operation);
                    break;
                case "delete":
                    System.out.println(operation);
                    break;
                default:
                    System.out.println(MyCRUD.class.getName() + ".performCRUDOperation() --> \""+ operation +"\" is not a valid CRUD operation.");
                    session.close();

            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }


    }


}
