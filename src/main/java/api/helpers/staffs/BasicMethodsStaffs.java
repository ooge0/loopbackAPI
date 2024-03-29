package api.helpers.staffs;

import api.helpers.Resources;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class BasicMethodsStaffs {
    private static Response response;
    static ValidatableResponse json;
    private static RequestSpecification request;
    static int response_status_code;
    private static String endPoint;


    static {
        try {
            endPoint = Resources.getEnvValue("STAFF");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printingStaffList() {
        request = given();
        response = request.when().get(endPoint);
    }

    public static void checkingResponseStatusCode(int reference_status_code) {
        response = request.when().get(endPoint);
        response_status_code = response.getStatusCode();
        assertEquals(response_status_code, reference_status_code);
    }

    public static void listSize(int staff_size_list) {
        request = given();
        response = request.when().get(endPoint);
        List<Map<String, List<String>>> allStaffs = response.jsonPath().getList("");
        System.out.println("\nI check the list after adding and it contains: " + allStaffs.size() + " items.\n");
        assertEquals(staff_size_list, allStaffs.size());

    }

    public static void statusCodeValidation(int status_code) {

        json = response.then().statusCode(status_code);
    }

}
