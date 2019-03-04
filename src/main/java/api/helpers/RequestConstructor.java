package api.helpers;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class RequestConstructor {
    private static String endPoint;


    public static void requestGenerator(String endPoint, String typeRequest, String bodyAsString, String id) {
        String[] header = new String[]{"Content-Type", "application/json"};

        switch (typeRequest) {
            case "GET":
                given()
                        .when()
                        .get(endPoint);
                break;
            case "POST":
                given()
                        .header(header[0], header[1])
                        .body(bodyAsString)
                        .when()
                        .post(endPoint);
                break;

            case "DELETE":
                given()
                        .header(header[0], header[1])
                        .body(bodyAsString)
                        .when()
                        .delete(endPoint + "/" + id);
                break;
            default:
                System.out.println("Please check HTTP verb!");


        }
    }
}