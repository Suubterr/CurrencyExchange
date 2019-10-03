import hibernate.MyCRUD;
import hibernate.entities.UserType;

import java.io.IOException;
import java.util.HashSet;

public class test {
    public static void main(String[] args) throws IOException {
        String[] userTypes = new String[]{"Djudette", "Djud", "DZiwnyTyp"};
        UserType ut;
        HashSet<UserType> utList = new HashSet<>();
        int id = 0;

        for(String s : userTypes){
            ut = new UserType();
            ut.setTypeName(s);
            utList.add(ut);
        }

        for(UserType i : utList) {
            MyCRUD.read(i);
        }
    }
}
