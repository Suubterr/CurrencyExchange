import hibernate.MyCRUD;
import hibernate.entities.UserType;

import java.io.IOException;
import java.util.HashSet;

public class test {
    public static void main(String[] args) throws IOException {
        String[] userTypes = new String[]{"Admin", "Employee", "Manager", "Client"};
        UserType ut;
        HashSet<UserType> utList = new HashSet<>();
        int id = 0;

        for(String s : userTypes){
            id++;
            ut = new UserType();
            ut.setTypeName(s);
            ut.setUsrTypeId(id);
            utList.add(ut);
        }

        for(UserType i : utList) {
            new MyCRUD().performCRUDOperation(1,i);
        }
    }
}
