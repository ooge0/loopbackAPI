package api.helpers.staffs;

import api.POJO.Staffs;
import api.helpers.Resources;
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

public class FunctionsStaffs {
    private static Response response;
    static ValidatableResponse json;
    private static RequestSpecification request;
    static int staff_massive_size, response_status_code;
    private static String endpoint;


    static {
        try {
            endpoint = Resources.getEnvValue("STAFF");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String bd = "{\n" +
            "  \" firstName\": \"fName-1nd\",\n" +
            "   \" staffPosition\": \"st_pos - 1nd\",\n" +
            "    \" lastName\": \"lName - 1nd\",\n" +
            "    \"starship\": \"starship - 1nd\"\n" +
            "}";

    public static void addingStaffBackground() {
        PostStaffRecCheckStCode.invoke();
        System.out.println("addingStaffBackground is completed\n");
    }

    public static void deleteAllStaffs() {
        requestGetManipulation();
        List<Map<String, List<String>>> allStaffs = response.jsonPath().getList("");
        System.out.println("\n");
        staff_massive_size = 1;
        for (Map<String, List<String>> staff_list : allStaffs) {
            String deleted_staff_ID = String.valueOf(staff_list.get("id"));
            given()
                    .when()
                    .delete(endpoint + "/" + deleted_staff_ID).then()
                    .statusCode(200)
                    .and()
                    .body("count", equalTo(1));
            System.out.print("\nDish[" + staff_massive_size + "]: " + staff_list.get(" firstName") + " id: " + staff_list.get("id") + " is DELETED");
            staff_massive_size++;
        }
    }

    public static void checkingExistedStaffList() {
        given()
                .when()
                .get(endpoint)
                .then().assertThat()
                .body("any { it.containsKey(' firstName') }", is(true));
        System.out.println("checkingExistedStaffList is completed\n");
    }

    public static void checkingItemResponseStatusCode(int status_code, String content_type) {
        given()
                .when()
                .get(endpoint)
                .then().assertThat()
                .body("any { it.containsKey(' firstName') }", is(true))
                .and()
                .statusCode(status_code)
                .contentType(content_type);
        System.out.println("checkingItemResponseStatusCode is completed\n");
    }


    private static void requestGetManipulation() {
        request = given();
        response = request.when().get(endpoint);
    }

    public static void addNewStaffRecord(String  firstName, String  lastName, String staff_positon, String starship) {
        System.out.println(" firstName: " +  firstName + ",  lastName: " +  lastName + ", staff_positon: " + staff_positon);
        JSONObject requestBody = creatingJsonObject( firstName,  lastName, staff_positon, starship);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());

        response = request.post(endpoint);
        response_status_code = response.getStatusCode();
        assertEquals(response_status_code, 200);
    }

    private static JSONObject creatingJsonObject(String  firstName, String  lastName, String staff_positon, String starship) {
        JSONObject requestBody = new JSONObject();
        requestBody.put(" firstName",  firstName);
        requestBody.put(" lastName",  lastName);
        requestBody.put(" staffPosition", staff_positon);
        requestBody.put("starship", starship);
        return requestBody;
    }


    public static void addSomeStaffRecords(DataTable table) {
        JSONObject requestBody = new JSONObject();
        //create an ArrayList
        List<Staffs.Staff> staffs;
        //store all items
        staffs = table.asList(Staffs.Staff.class);
        //create FOR cycle for each elements of List<Staffs>
        for (Staffs.Staff staff : staffs) {
            creatingStaffObectFromObject(requestBody, staff);
            RequestSpecification request = RestAssured.given();
            request.header("Content-Type", "application/json");
            request.body(requestBody.toString());
            request.post(endpoint);
            int statusCode = response.getStatusCode();
            assertEquals(statusCode, 200);
            System.out.println("*** addSomeStaffRecords **** \n" + response.getBody().asString());
        }
    }

    private static void creatingStaffObectFromObject(JSONObject requestBody, Staffs.Staff staff) {
        requestBody.put(" firstName", staff. firstName);
        requestBody.put(" lastName", staff. lastName);
        requestBody.put(" staffPosition", staff. staffPosition);
        requestBody.put("starship", staff.starship);
    }


    public static void checkingPositionAndName(int hero_position, DataTable table) {
        response = request.when().get(endpoint);
        System.out.println("I check that selected item has: " + hero_position + " position.");
        List<Map<String, List<String>>> allStaffs = response.jsonPath().getList("");
        List<Staffs.Staff> staffs;
        //store all items
        staffs = table.asList(Staffs.Staff.class);
        System.out.println("\nI check DataTable  record. It has parameters: " + allStaffs.get(hero_position - 1).get(" firstName") + " " + allStaffs.get(hero_position - 1).get(" lastName") + " " + allStaffs.get(hero_position - 1).get(" staffPosition"));
        for (Staffs.Staff staff : staffs) {
            System.out.println("\nI check response. It has parameters: " + staff. firstName + " " + staff. lastName + " " + staff. staffPosition);
            assertEquals((allStaffs.get(hero_position - 1).get(" firstName")), staff. firstName);
            assertEquals((allStaffs.get(hero_position - 1).get(" lastName")), staff. lastName);
            assertEquals((allStaffs.get(hero_position - 1).get(" staffPosition")), staff. staffPosition);
        }
    }

    public static void printingRecordsList() {
        requestGetManipulation();
        List<Map<String, List<String>>> allStaffs = response.jsonPath().getList("");
        staff_massive_size = 0;
        for (Map<String, List<String>> staff_list : allStaffs) {
            given()
                    .when()
                    .get(endpoint)
                    .then()
                    .statusCode(200);
            System.out.print("\nDish[" + staff_massive_size + "]: " + staff_list.get(" firstName") + " id: " + staff_list.get("id"));
            staff_massive_size++;
        }

    }

    public static void deletingRecords(int first_item, int last_item) {
        int item_position_first = first_item - 1;

        response = request.when().get(endpoint);
        List<Map<String, List<String>>> allStaffs = response.jsonPath().getList("");
        System.out.println("\nI choose first staff record: " + "\t name: " + allStaffs.get(item_position_first).get(" firstName")
                + "\t id: " + allStaffs.get(item_position_first).get("id"));
        String first_delete_ID_item = String.valueOf(allStaffs.get(item_position_first).get("id"));

        given()
                .when()
                .delete(endpoint + "/" + first_delete_ID_item).then()
                .statusCode(200)
                .and()
                .body("count", equalTo(1));

        response = request.when().get(endpoint);
        int item_position_last = last_item - 2;
        allStaffs = response.jsonPath().getList("");
        System.out.println("\nI choose last  record: " + "\t name: " + allStaffs.get(item_position_last).get(" firstName")
                + "\t id: " + allStaffs.get(item_position_last).get("id"));

        String last_delete_ID_item = String.valueOf(allStaffs.get(item_position_last).get("id"));

        given()
                .when()
                .delete(endpoint + "/" + last_delete_ID_item).then()
                .statusCode(200)
                .and()
                .body("count", equalTo(1));
    }

    public static void checkingLastRecordNamePosition(DataTable table) {
        response = request.when().get(endpoint);
        List<Map<String, List<String>>> allStaffs = response.jsonPath().getList("");
        int staf_list_size = allStaffs.size() - 1;
        System.out.println("staf_list_size: " + staf_list_size);
        List<Staffs.Staff> staffs;
        //store all items
        staffs = table.asList(Staffs.Staff.class);
        System.out.println("\nI check DataTable record. It has parameters: " + allStaffs.get(staf_list_size).get(" firstName") + " " + allStaffs.get(staf_list_size).get(" lastName") + " " + allStaffs.get(staf_list_size).get(" staffPosition"));
        for (Staffs.Staff staff : staffs) {
            System.out.println("\nI check response. It has parameters: " + staff. firstName + " " + staff. lastName + " " + staff. staffPosition);
        }
    }

    private static class PostStaffRecCheckStCode {
        private static void invoke() {
            given()
                    .header("Content-Type", "application/json")
                    .body(bd)
                    .when()
                    .post(endpoint)
                    .then()
                    .statusCode(200);
        }
    }
}
