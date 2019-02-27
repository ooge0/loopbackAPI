package api.helpers;

import api.stepDefinitions.Staffs;
import cucumber.api.DataTable;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

public class BasicMethods {
    private static Response response;
    static ValidatableResponse json;
    private static RequestSpecification request;
    static int response_status_code;
    private static String ENDPOINT_STAFF;


    static {
        try {
            ENDPOINT_STAFF = Resources.getEnvValue();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printingStaffList() {
        request = given();
        response = request.when().get(ENDPOINT_STAFF);
    }

    public static void checkingResponseStatusCode(int verification_status_code) {
        response = request.when().get(ENDPOINT_STAFF);
        response_status_code = response.getStatusCode();
        assertEquals(response_status_code, verification_status_code);
    }

    public static void listSize(int staff_size_list) {
        request = given();
        response = request.when().get(ENDPOINT_STAFF);
        List<Map<String, List<String>>> allStaffs = response.jsonPath().getList("");
        System.out.println("\nI check list after adding and it contains: " + allStaffs.size() + " items.\n");
        assertEquals(staff_size_list, allStaffs.size());

    }

    public static void statusCodeValidation(int status_code) {
        json = response.then().statusCode(status_code);
    }

}
