package api.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Resources {


    public static String defaultRequestWarning() {
        String warningText = "Error - Please check entered information";
        return warningText;
    }

    public static String defaultEnvWarning() {
        String warningText = "Error - Please check env.properties file";
        return warningText;
    }

    public static String envPropertyFilePath() {
        String envPropertyFilePath = "./env.properties";
        return envPropertyFilePath;
    }


    public static String getEnvValue(String entity) throws IOException {
        String serviceURL = null;
        String envValue = System.getProperty("urlConfig");
        System.out.println("envValue: " + envValue);
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(Resources.envPropertyFilePath());
        prop.load(fis);
        if ("DISH".equals(envValue)) {
            serviceURL = (String) prop.get("ENDPOINT_DISHES");
            System.out.println("serviceURL:" + serviceURL);

        } else if ("STAFF".equals(envValue)) {
            serviceURL = (String) prop.get("ENDPOINT_STAFF");
            System.out.println("serviceURL:" + serviceURL);
        } else if ("RECORD".equals(envValue)) {
            serviceURL = (String) prop.get("ENDPOINT_RECORD");
            System.out.println("serviceURL:" + serviceURL);

        } else {
            System.out.println(Resources.defaultEnvWarning());
        }
        return serviceURL;
    }
}