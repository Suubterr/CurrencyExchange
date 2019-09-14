package tools;

import java.util.Properties;

public class MyProperties {
    private Properties myProperties = new Properties();

    public void setMyProperties(String path) {
        MyFileReader fr = new MyFileReader(path);
        try {
            myProperties.load(fr.read());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Properties getDbConProp() {
        return this.myProperties;
    }
}
