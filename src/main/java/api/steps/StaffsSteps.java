package api.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import api.helpers.Resources;
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

public class StaffsSteps {


    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;
//    private String Resources.getEnvValue() = "http://localhost:3000/api/staffs";
    String url = "http://localhost:3000/api/staffs";
    int staff_massive_size;
    int response_status_code;

    @When("^I ADD one staff item in background_first$")
    public void iADDOneStaffItemInBackground_first$() {
        given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"first_name\": \"fName-1nd\",\n" +
                        "   \"staff_position\": \"st_pos - 1nd\",\n" +
                        "    \"last_name\": \"lName - 1nd\"\n" +
                        "}")
                .when()
                .post(url)
                .then()
                .statusCode(200);
        System.out.println("iADDOneStaffItemInBackground_first is completed\n");
//        System.out.println(response.getBody().asString());
    }

    @Given("^I check existing of the Staff list$")
    public void i_check_existing_of_the_staff_list() throws IOException {
        given()
                .when()
                .get(url)
//                .get(Resources.getEnvValue())
                .then().assertThat()
                .body("any { it.containsKey('first_name') }", is(true));
        System.out.println("i_check_existing_of_the_staff_list is completed\n");
    }

    @And("^I check response and it has StatusCode (\\d+) and contentType: ([^\\\"]*)$")
    public void iCheckRessponseAndItHasStatusCodeAndContentTypeApplicationJson(int status_code, String content_type) throws IOException {
        given()
                .when()
                .get(url)
//                .get(Resources.getEnvValue())
                .then().assertThat()
                .body("any { it.containsKey('first_name') }", is(true))
                .and()
                .statusCode(status_code)
                .contentType(content_type);
        System.out.println("iCheckRessponseAndItHasStatusCodeAndContentTypeApplicationJson is completed\n");

    }

    @And("I print information about Staff list")
    public void get_prettyPrint_of_staff_list() throws IOException {
        request = given();
        response = request.when().get(url);
//                .get(Resources.getEnvValue());
        //  System.out.println("response: " + response.prettyPrint());

    }


    @Then("^I delete all records from the Staff list$")
    public void i_delete_all_records_from_staff_list() throws IOException {
//        request = given();
//        response = request.when().get(Resources.getEnvValue());
        List<Map<String, List<String>>> allStaffs = response.jsonPath().getList("");
        staff_massive_size = 1;

        for (Map<String, List<String>> staff_list : allStaffs) {
            String deleted_staff_ID = String.valueOf(staff_list.get("id"));
            given()
                    .when()
                    .delete(Resources.getEnvValue() + "/" + deleted_staff_ID).then()
                    .statusCode(200)
                    .and()
                    .body("count", equalTo(1));
            System.out.println("\nDish[" + staff_massive_size + "]: " + staff_list.get("first_name") + " id: " + staff_list.get("id") + " is DELETED");
            staff_massive_size++;
        }

    }

    @And("^I check that staff list and it contains (\\d+) item$")
    public void i_check_staff_list_and_it_contains_0_items(int empty_list_value)  {
        try {
            response = request.when().get(Resources.getEnvValue());
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Map<String, List<String>>> allStaffs = response.jsonPath().getList("");
        // allStaffs = response.jsonPath().getList("");
        System.out.println("\nStaff list contains: " + allStaffs.size() + " items after deleting of all items\n");
        assertEquals(empty_list_value, allStaffs.size());
    }

    @And("^I check the Staff list and statusCode is (\\d+)$")
    public void i_Check_staff_list_Response_Of_StatusCode_Is(int verification_status_code) throws IOException {
        //json = response.then().statusCode(status_code);
        response = request.when().get(Resources.getEnvValue());
        response_status_code = response.getStatusCode();
        assertEquals(response_status_code, verification_status_code);

    }

    @And("^I ADD one staff record as ([^\\\"]*), ([^\\\"]*), ([^\\\"]*)$")

    public void I_add_new_one_staff_record(String first_name, String last_name, String staff_positon) throws IOException {
        System.out.println("first_name: " + first_name + ", last_name: " + last_name + ", staff_positon: " + staff_positon);
//        request = given();
        JSONObject requestBody = new JSONObject();
        requestBody.put("first_name", first_name);
        requestBody.put("last_name", last_name);
        requestBody.put("staff_position", staff_positon);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());
        response = request.post(Resources.getEnvValue());

//        System.out.println("I_add_new_one_staff_record is completed\n");
//        System.out.println("\ngetStatusCode: " + response.getStatusCode());
        response_status_code = response.getStatusCode();
        assertEquals(response_status_code, 200);
    }

    @And("^I ADD one staff item in background$")
    public void iADDOneStaffItemInBackground() throws IOException {

        request = given(); //test_background$
        given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"first_name\": \"test_background\",\n" +
                        "   \"staff_position\": \"test_background\",\n" +
                        "    \"last_name\": \"test_background\"\n" +
                        "}")
                .when()
                .post(Resources.getEnvValue())
                .then()
                .statusCode(200);
//        System.out.println(response.getBody().asString());
        System.out.println("iADDOneStaffItemInBackground is completed\n");
    }

    @And("^I ADD 3 staffs items$")
    public void iAddNextItems(DataTable table) throws IOException {
        JSONObject requestBody = new JSONObject();
        System.out.println("\nI add only one staff item.");
        //create an ArrayList
        List<Staff> staffs;
        //store all items
        staffs = table.asList(Staff.class);
        //create FOR cycle for each elements of List<Dish>
        for (Staff staff : staffs) {
            System.out.println("\nname: " + staff.first_name + " " + staff.last_name + ", staff_position: " + staff.staff_position);
            requestBody.put("first_name", staff.first_name);
            requestBody.put("last_name", staff.last_name);
            requestBody.put("staff_position", staff.staff_position);

            RequestSpecification request = RestAssured.given();
            request.header("Content-Type", "application/json");
            request.body(requestBody.toString());
//            System.out.println("response" + response.getBody().asString());
            request.post(Resources.getEnvValue());

            int statusCode = response.getStatusCode();
            assertEquals(statusCode, 200);
//            System.out.println("Status Code is : " + statusCode);
            System.out.println(response.getBody().asString());
        }
    }

    @And("^I ADD one staff item in background_second$")
    public void iADDOneStaffItemInBackground_second$() throws IOException {
        given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"first_name\": \"fName-2nd\",\n" +
                        "   \"staff_position\": \"st_pos - 2nd\",\n" +
                        "    \"last_name\": \"lName - 2nd\"\n" +
                        "}")
                .when()
                .post(Resources.getEnvValue())
                .then()
                .statusCode(200);
//        System.out.println(response.getBody().asString());
    }

    @And("^I check that list contains (\\d+) items$")
    public void I_check_that_list_contains_items_and_statusCode_is(int staff_size_list) throws IOException {

        response = request.when().get(Resources.getEnvValue());
        List<Map<String, List<String>>> allStaffs = response.jsonPath().getList("");
        System.out.println("\nI check list after adding and it contains: " + allStaffs.size() + " items.\n");
        assertEquals(staff_size_list, allStaffs.size());

    }

    @And("^I check that last request has statusCode: (\\d+)$")
    public void i_check_response_of_the_status_code_is(int status_code) {
        json = response.then().statusCode(status_code);
    }

    @And("^I check that (\\d+) record has name and it has next positon$")
    public void iCheckThatHeroHasNameAndItHasPositon(int hero_position, DataTable table) throws IOException {
        response = request.when().get(Resources.getEnvValue());
        System.out.println("I check that selected item has: " + hero_position + " position.");

        List<Map<String, List<String>>> allStaffs = response.jsonPath().getList("");
        List<Staff> staffs;

        //store all items
        staffs = table.asList(Staff.class);
        System.out.println("\nI check DataTable  record. It has parameters: " + allStaffs.get(hero_position - 1).get("first_name") + " " + allStaffs.get(hero_position - 1).get("last_name") + " " + allStaffs.get(hero_position - 1).get("staff_position"));
        for (Staff staff : staffs) {
            System.out.println("\nI check response. It has parameters: " + staff.first_name + " " + staff.last_name + " " + staff.staff_position);
            assertEquals((allStaffs.get(hero_position - 1).get("first_name")), staff.first_name);
            assertEquals((allStaffs.get(hero_position - 1).get("last_name")), staff.last_name);
            assertEquals((allStaffs.get(hero_position - 1).get("staff_position")), staff.staff_position);
        }
    }

    @And("^I print the Staff list$")
    public void iPrintStaffList() throws IOException {
        request = given();
        response = request.when().get(Resources.getEnvValue());
        List<Map<String, List<String>>> allStaffs = response.jsonPath().getList("");
        staff_massive_size=0;
        for (Map<String, List<String>> staff_list : allStaffs) {
            given()
                    .when()
                    .get(Resources.getEnvValue() )
                    .then()
                    .statusCode(200);
            System.out.println("\nDish[" + staff_massive_size + "]: " + staff_list.get("first_name") + " id: " + staff_list.get("id") );
            staff_massive_size++;
        }
    }


    @When("^I delete (\\d+) and (\\d+) item from DB$")
    public void iDeleteAndItemFromDB(int first_item, int last_item) throws IOException {
        int item_position_first = first_item - 1;

        response = request.when().get(Resources.getEnvValue());
        List<Map<String, List<String>>> allStaffs = response.jsonPath().getList("");
        // int dish_massive_size = allDishes.size();
        System.out.println("\nI choose first staff record: " + "\t name: " + allStaffs.get(item_position_first).get("first_name")
                + "\t id: " + allStaffs.get(item_position_first).get("id"));
        String first_delete_ID_item = String.valueOf(allStaffs.get(item_position_first).get("id"));
        given()
                .when()
                .delete(Resources.getEnvValue() + "/" + first_delete_ID_item).then()
                .statusCode(200)
                .and()
                .body("count", equalTo(1));

        response = request.when().get(Resources.getEnvValue());
        int item_position_last = last_item - 2;
        allStaffs = response.jsonPath().getList("");
        System.out.println("\nI choose last  record: " + "\t name: " + allStaffs.get(item_position_last).get("first_name")
                + "\t id: " + allStaffs.get(item_position_last).get("id"));

        String last_delete_ID_item = String.valueOf(allStaffs.get(item_position_last).get("id"));

        given()
                .when()
                .delete(Resources.getEnvValue() + "/" + last_delete_ID_item).then()
                .statusCode(200)
                .and()
                .body("count", equalTo(1));


    }

    @Then("^I check that staff list contains (\\d+) item$")
    public void iCheckThatDBContainsOnlyItem(int staff_size_list) throws IOException {
        response = request.when().get(Resources.getEnvValue());
        List<Map<String, List<String>>> allStaffs = response.jsonPath().getList("");
        System.out.println("\nI check staff list after adding and it contains: " + allStaffs.size() + " items.\n");
        assertEquals(staff_size_list, allStaffs.size());

    }

    @And("^I check that last item has name and position$")
    public void thisItemHasNameAndPosition(DataTable table) throws IOException {
        response = request.when().get(Resources.getEnvValue());
        List<Map<String, List<String>>> allStaffs = response.jsonPath().getList("");
        int staf_list_size = allStaffs.size()-1;
        System.out.println("staf_list_size: " + staf_list_size);
        List<Staff> staffs;

        //store all items
        staffs = table.asList(Staff.class);
        System.out.println("\nI check DataTable record. It has parameters: " + allStaffs.get(staf_list_size).get("first_name") + " " + allStaffs.get(staf_list_size).get("last_name") + " " + allStaffs.get(staf_list_size).get("staff_position"));
        for (Staff staff : staffs) {
            System.out.println("\nI check response. It has parameters: " + staff.first_name + " " + staff.last_name + " " + staff.staff_position);
//
//            assertEquals((allStaffs.get(staf_list_size).get("first_name")), staff.first_name);
//            assertEquals((allStaffs.get(staf_list_size).get("last_name")), staff.last_name);
//            assertEquals((allStaffs.get(staf_list_size).get("staff_position")), staff.staff_position);
        }
    }



    public class Staff {
        public String first_name;
        public String last_name;
        public String staff_position;

        Staff(String firstName, String lastName, String staffPositon) {
            first_name = firstName;
            last_name = lastName;
            staff_position = staffPositon;
        }
    }

}
