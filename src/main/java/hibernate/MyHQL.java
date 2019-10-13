package hibernate;

public class MyHQL {
    String query;
    Object object;
    String operation;

    public MyHQL(String operation, Object object) {
        this.object = object;
        this.operation = operation;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        StringBuffer sf = new StringBuffer();
        sf.append(operation.toUpperCase());
        sf.append("FROM");
        sf.append(object.getClass().getSimpleName());
        this.query = query;
    }
}
