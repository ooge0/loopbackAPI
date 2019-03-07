package api.helpers;

import api.POJO.Records;
import api.POJO.Staffs;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class RequestConstructor {
    private static String endPoint;
    private static Response response;
    static ValidatableResponse json;
    private static RequestSpecification request;
    static int response_status_code;


    public static void requestCompiler(String endPoint, String typeRequest, String bodyAsString, String id) {
        String[] header = new String[]{"Content-Type", "application/json"};
        Response result=null;

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
                        .post(endPoint)
                        .then().statusCode(200);
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
//        return result;
    }

    public static void checkingExistingCollection() {
        Response response = request.when().get(endPoint);
        List<Map<String, List<String>>> allStaffs = response.jsonPath().getList("");
        System.out.println("\nI check the list after adding and it contains: " + allStaffs.size() + " items.\n");
        assertNotNull(allStaffs);
    }



}