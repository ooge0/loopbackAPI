package api.helpers;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class RequestConstructor {
    private static String ENDPOINT_STAFF;
    private String[] header = {"Content-Type", "application/json"};

    static {
        try {
            ENDPOINT_STAFF = Resources.getEnvValue();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void requestGenerator(String typeRequest, String bodyAsString, String[] header) {
        switch (typeRequest) {
            case "GET":
                given()
                        .header(header[1], header[2])
                        .when()
                        .get(ENDPOINT_STAFF);
                break;
            case "POST":
                given()
                        .header(header[1], header[2])
                        .body(bodyAsString)
                        .when()
                        .post(ENDPOINT_STAFF);
                break;
            default:
                System.out.println("Please check HTTP verb!");


        }
    }
}