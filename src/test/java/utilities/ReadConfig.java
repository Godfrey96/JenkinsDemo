package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    String sDefaultPath = System.getProperty("user.dir");
    Properties prop;

    public ReadConfig(){
        File src = new File(sDefaultPath + "/Configuration/config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is: " + e.getMessage());
        }
    }

    public String getApplicationURL(){
        String url = prop.getProperty("baseURL");
        return url;
    }

    public String getChromePath(){
        String chromePath = prop.getProperty("chromepath");
        return chromePath;
    }

    public String getFirefoxPath(){
        String firefoxPath = prop.getProperty("firefoxpath");
        return firefoxPath;
    }
}
