package api.helpers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RequestConstructor {
    private static String endPoint;
    private static Response response;
    private RequestSpecification request;
    static ValidatableResponse json;
    static int response_status_code;


    public static Response requestCompiler(String endPoint, String typeRequest, String bodyAsString, String id) {
        String[] header = new String[]{"Content-Type", "application/json"};
        RequestSpecification request = RestAssured.given();
        switch (typeRequest) {
            case "GET":
                response = RestAssured.given().get(endPoint);
                break;
            case "POST":
                request = RestAssured.given()
                        .header(header[0], header[1])
                        .body(bodyAsString);
                response = request.post(endPoint);
                response_status_code = response.getStatusCode();
                assertEquals(response_status_code, 200);
                break;
            case "DELETE":
                request
                        .header(header[0], header[1])
                        .body(bodyAsString);
                response = request.delete(endPoint + "/" + id);
                break;
            default:
                System.out.println("Please check the 'requestCompiler' method!");
        }
        return response;
    }

    public static void checkingExistingCollection() {
        List<Map<String, List<String>>> allEntities = response.jsonPath().getList("");
        System.out.println("\nI check the list after adding and it contains: " + allEntities.size() + " items.\n");
        assertNotNull(allEntities);
    }


}