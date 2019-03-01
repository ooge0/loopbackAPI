package ngTests;//package restassured.stepDefinitions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class staffsTestNG {
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;
    int status_code = 200;
    int counter = 1;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:3000";
        RestAssured.basePath = "/api";
        request = given();
        response = request.when().get("/staffs");


    }

    @Test
    public void get_prettyPrint_of_staffs_and_StatusCode_is_200() {
        System.out.println("response: " + response.prettyPrint());
        json = response.then().statusCode(status_code);

    }

    @Test
    public void get_name_of_staffs() {
        List<Map<String, List<String>>> allStaffs = response.jsonPath().getList("");
        System.out.println(allStaffs.get(1).get("firstName"));

        for (Map<String, List<String>> staff_first_name : allStaffs) {
            System.out.println(counter + ") First name: " + staff_first_name.get("firstName"));
            counter++;
        }
    }

    @Test
    public void get_staff_id() {
        List<Map<String, List<String>>> allStaffs = response.jsonPath().getList("");
        for (Map<String, List<String>> staff_first_name : allStaffs) {
            System.out.println(counter + ")id: " + staff_first_name.get("id"));
            counter++;
        }
    }

    @Test
    public void get_price_of_dishes() {
        List<Map<String, List<String>>> allStaffs = response.jsonPath().getList("");
        int staff_massive_size = allStaffs.size();
        String test_value;
        System.out.println("Staffs list contains: " + staff_massive_size);
        for (Map<String, List<String>> staffs_db : allStaffs) {
            System.out.println("Staffs[" + staff_massive_size + "]: "
                    + "\t id: " + staffs_db.get("id")
                    + "\t firstName: " + staffs_db.get("firstName")
                    + "\t last_name: " + staffs_db.get("last_name")
                    + "\t staff_position: " + staffs_db.get("staff_position"));
            staff_massive_size--;

        }
        test_value = String.valueOf(allStaffs.get(1).get("id"));
        System.out.println("test_value: " + test_value);

    }


    @Test(enabled = true)
    public void delete_staff_by_ID() {
        List<Map<String, List<String>>> allStaffs = response.jsonPath().getList("");
        int staff_massive_size = allStaffs.size();
        int last_item = staff_massive_size - 1;

        System.out.println("Staffs massive contains: " + staff_massive_size + " items");

        System.out.println("Deleted last Staffs record contained: " + "\n firstName: " + allStaffs.get(last_item).get("firstName")
                + "\tlast_name: " + allStaffs.get(last_item).get("last_name")
                + "\tid: " + allStaffs.get(last_item).get("id")
                + "\tstaff_position: " + allStaffs.get(1).get("staff_position"));
        System.out.println("Staffs collection contains: '" + last_item  +" 'records");
        String deleted_staff_ID;

        deleted_staff_ID = String.valueOf(allStaffs.get(last_item).get("id"));
        given()
                .when()
                .delete("/staffs/" + deleted_staff_ID)
                .then()
                .statusCode(200)
                .and()
                .body("count",equalTo(last_item));

        ;

    }

    @Test(enabled = true)
    public void delete_all_dishes_by_ID() {
        List<Map<String, List<String>>> allStaffs = response.jsonPath().getList("");
        int staff_massive_size = allStaffs.size();

        System.out.println("Staffs massive contains: " + staff_massive_size + " items");
        for (Map<String, List<String>> staffs_db : allStaffs) {
            String deleted_staff_ID = String.valueOf(staffs_db.get("id"));
            System.out.println("deleted_staff_ID: " + deleted_staff_ID);
            given()
                    .when()
                    .delete("/staffs/" + deleted_staff_ID);

            System.out.println("Staffs[" + counter + "]: " + "firstName: " + staffs_db.get("firstName") +
                    "\t id: " + staffs_db.get("id") + " is DELETED\n");
            staff_massive_size--;
            counter ++;
        }
    }

    @Test(enabled = true)
    public void addCucumber() {
        for (int i = 0; i < 3; i++) {
            given().body("{\n" +
                    "  \"firstName\": \"firstName"+i+"\",\n" +
                    "  \"last_name\": \"last_name"+i+"\",\n" +
                    "  \"staff_position\": \"staff_position"+i+"\",\n" +
                    "  \"starship\": \"ship"+i+"\"\n" +
                    "}")
                    .contentType(ContentType.JSON)
                    .when()
                    .post("/staffs")
                    .then()
                    .statusCode(200);
        }
    }



    @Test(enabled = false)
    public void get_dishes_by_ID() {
        given()
                .when()
                .contentType(ContentType.JSON)
                .get("/staffs/5b1e99d42548d06378fe20a6")
                .then()
                .statusCode(200);

    }


    @Test
    public void post_Request_for_Dishes() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("firstName", "firstName");
        requestBody.put("last_name", "last_name");
        requestBody.put("staff_position", "staff_positon");
        requestBody.put("starship", "starship");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());
        Response response = request.post("/staffs");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        String successCode = response.jsonPath().get("SuccessCode");
        System.out.println("Status Code is : " + statusCode);
        System.out.println("SuccessCode is : " + successCode);
        System.out.println(response.getBody().asString());
    }

    @Test
    public void post_Request_for_staffs() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("firstName", "Wonder");
        requestBody.put("last_name", "woman");
        requestBody.put("staff_position", "hero");
        requestBody.put("starship", "starship");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());
        Response response = request.post("/staffs");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println("Status Code is : " + statusCode);
        System.out.println(response.getBody().asString());
    }

    @Test
    public void postRequestExampleItemsDB() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("firstName", "Wonder");
        requestBody.put("last_name", "woman");
        requestBody.put("staff_position", "hero");
        requestBody.put("starship", "starship");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());
        Response response = request.post("http://localhost:3000/api/staffs");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        String successCode = response.jsonPath().get("SuccessCode");
        System.out.println("Status Code is : " + statusCode);
        System.out.println(response.getBody().asString());
    }
}
