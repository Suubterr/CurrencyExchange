package tools;

import java.io.BufferedReader;
import java.io.FileReader;

public class MyFileReader {

    String path;

    public MyFileReader(String filePath) {
        path = filePath;
    }

    public BufferedReader read() throws Exception {

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(path));
        } catch (Exception e) {
            throw new Exception("Error during reading from file --> " + e.getMessage());
        }

        return br;
    }
}
