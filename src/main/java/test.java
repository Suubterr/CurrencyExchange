import tools.MyFileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class test {
    public static void main(String[] args) throws IOException {
        MyFileReader file = new MyFileReader("src/main/java/resources/hibernate.properties");
        Properties prop = new Properties();

        try {
            br = file.read();
            prop.load(br);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(prop.toString());
    }
}
