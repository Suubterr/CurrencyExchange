package hibernate;

import hibernate.entities.*;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

import static hibernate.Tools.getSession;

public class MyCRUD {

    private static Session session;
    private static String operationName;

    public Object create(MyEntity object) {
        session = getSession();
        operationName = "Create";
        try {
            session.save(object);
        }catch (Exception e) {
            System.out.println(
                    this.getClass().getName()
                            + '.' + this.getClass().getEnclosingMethod().getName()
                            + " || " + e.getMessage());
        }
        return object;
    }

    public Object read(MyEntity object) {
        operationName = "Read";
        String hql = ()
        System.out.println("Query: " + hql);
        Query query = session.createQuery(hql);
        List results = query.list();
        return results;
    }

    public Object update(MyEntity object) {
        return getSession();
    }

    public Object delete(MyEntity object) {
        return getSession();
    }
}
