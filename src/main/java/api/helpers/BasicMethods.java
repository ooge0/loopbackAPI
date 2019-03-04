package api.helpers;

import java.io.IOException;

public class BasicMethods {

    public static String gettingEndPoint(String entity) {
        String endPoint = null;
        try {
            endPoint = Resources.getEnvValue(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return endPoint;
    }

    public static String gettingHttpVerb(String actionMethod) {
        switch (actionMethod) {
            case "add":
                actionMethod = "POST";
                break;
            case "delete":
                actionMethod = "DELETE";
                break;
            case "check":
                actionMethod = "GET";
                break;
            default:
                System.out.println("Please check HTTP verb!");
        }
        return actionMethod;
    }

}
