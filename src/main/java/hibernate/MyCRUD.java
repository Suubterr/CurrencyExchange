package hibernate;

import hibernate.entities.Currency;
import hibernate.entities.Transactions;
import hibernate.entities.UserType;
import hibernate.entities.Users;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

public class MyCRUD {
    private static SessionFactory sf;
    private static Session session;

    private static void performCRUDOperation(int operation, Object object) {

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
            session.beginTransaction();

            switch (operation) {
                case 1: // create:
                    System.out.println(operation + " - create " + object.toString());
                    try{
                        session.save(object);
                    }catch (HibernateException e) {
                        if(session.getTransaction() != null){
                            session.getTransaction().rollback();
                        }
                        throw new HibernateException("Problem during insert --> " + object.getClass() + " --> " + e.getMessage());
                    }

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
                    System.out.println(MyCRUD.class.getName() + ".performCRUDOperation() --> \"" + operation + "\" is not a valid CRUD operation.");
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public static void create(Object object) {
        performCRUDOperation(1, object);
    }

    public static void read(Object object) {
        performCRUDOperation(2, object);
    }

    public static void update(Object object) {
        performCRUDOperation(3,object);
    }

    public static void delete(Object object) {
        performCRUDOperation(4,object);
    }
}
