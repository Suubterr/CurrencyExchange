package hibernate;

import hibernate.entities.Currency;
import hibernate.entities.Transactions;
import hibernate.entities.UserType;
import hibernate.entities.Users;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.Field;

public class MyCRUD {
    private static SessionFactory sf;
    private static Session session;
    private static String operationName;
    private static String info;

    private static Object performCRUDOperation(int operation, Object object) {

        info = "Performing \"" + operationName + "\" on object " + object.toString();

        try {
            sf = getSf();
            session = sf.openSession();
            session.beginTransaction();

            switch (operation) {
                case 1: // create:
                    operationName = "insert";
                    session.save(object);
                    System.out.println(info);
                    return object;
                case 2: //read
                    operationName = "select";
                    System.out.println(info);
                    String query = getQuery(operation, object);

                    object = session.find(object.getClass(), 1);
                    return object;
                case 3: //update
                    System.out.println(operation + " - update");
                    break;
                case 4: //delete
                    System.out.println(operation + " - delete");
                    break;
                default:
                    System.out.println(MyCRUD.class.getName() + ".performCRUDOperation() --> \"" + operation + "\" is not a valid CRUD operation.");
            }
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return null;
    }

    private static String getQuery(int operation, Object object) {
        StringBuffer query = new StringBuffer();

        query.append(operationName);
        query.append(" from " + Object.class.getSimpleName());

        Field[] fields = Object.class.getFields();
        // TODO: iterate class fields and add them to the where clause if not null

        return query.toString();
    }

    public static SessionFactory getSf() {
        return new Configuration()
                .addPackage("java.hibernate.entities")
                .addAnnotatedClass(Currency.class)
                .addAnnotatedClass(Users.class)
                .addAnnotatedClass(UserType.class)
                .addAnnotatedClass(Transactions.class)
                .configure()
                .buildSessionFactory();
    }

    public static Object create(Object object) {
        return performCRUDOperation(1, object);
    }

    public static Object read(Object object) {
        return performCRUDOperation(2, object);
    }

    public static Object update(Object object) {
        return performCRUDOperation(3, object);
    }

    public static Object delete(Object object) {
        return performCRUDOperation(4, object);
    }
}
