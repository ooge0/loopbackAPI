package api.ngTests;//package restassured.steps;

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

public class dishesTestNG {
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;
    int status_code = 200;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:3000";
        RestAssured.basePath = "/api";
        request = given ();
        response = request.when().get("/dishes");


    }

    @Test
    public void get_prettyPrint_of_dishes_and_StatusCode_is_200 () {
        System.out.println("response: " + response.prettyPrint());
        json = response.then().statusCode(status_code);

    }

    @Test
    public void get_name_of_dishes () {
        List<Map<String, List<String>>> allDishes = response.jsonPath().getList("");
        System.out.println(allDishes.get(1).get("name"));
        for (Map <String ,List <String>> dish_name: allDishes) {
            System.out.println("Dish "+ dish_name.get("name"));
        }
    }

    @Test
    public void get_id_of_dishes () {
        List<Map<String, List<String>>> allDishes = response.jsonPath().getList("");
        for (Map <String ,List <String>> dish_name: allDishes) {
            System.out.println("Dish "+ dish_name.get("id"));
        }
    }
    @Test
    public void get_price_of_dishes () {
        List<Map<String, List<String>>> allDishes = response.jsonPath().getList("");
        int dish_massive_size =  allDishes.size();
        String test_value ;
        System.out.println("Dishes list contains: " + dish_massive_size);
        for (Map <String ,List <String>> dish_db: allDishes) {
            System.out.println("Dish["+dish_massive_size+"]: "+dish_db.get("name")+ "\t price: "+  dish_db.get("price") +
                    "\t id: "+  dish_db.get("id")+ "\t currency: "+  dish_db.get("currency"));
            dish_massive_size --;

        }
        test_value = String.valueOf(allDishes.get(1).get("id"));
        System.out.println("test_value: " + test_value);

    }


    @Test(enabled = true)
    public void delete_dishes_by_ID() {
    List<Map<String, List<String>>> allDishes = response.jsonPath().getList("");
        int dish_massive_size =  allDishes.size();
        int last_item = dish_massive_size-1;

        System.out.println("Dishes massive contains: " + dish_massive_size+ " items");

        System.out.println("Dish: "  + "\t name: "+  allDishes.get(last_item).get("name")
                + "\t price: "+  allDishes.get(last_item).get("price")
                +"\t id: "+  allDishes.get(last_item).get("id")
                + "\t currency: "+  allDishes.get(1).get("currency"));
        String deleted_dish_ID ;

        deleted_dish_ID = String.valueOf(allDishes.get(last_item).get("id"));
                given()
                .when()
                .delete("/dishes/"+deleted_dish_ID)
                /*
                .then()
                .statusCode(200)
                .and()
                .body("count",equalTo("1"));
                */
                ;

    }

    @Test(enabled = true)
    public void delete_all_dishes_by_ID() {
        List<Map<String, List<String>>> allDishes = response.jsonPath().getList("");
        int dish_massive_size =  allDishes.size();
        System.out.println("Dishes massive contains: " + dish_massive_size+ " items");
        for (Map <String ,List <String>> dish_db: allDishes) {
            String deleted_dish_ID = String.valueOf(dish_db.get("id"));
            System.out.println("deleted_dish_ID: "+ deleted_dish_ID);

            System.out.println("Dish["+dish_massive_size+"]: "+dish_db.get("name")+
                    "\t id: "+  dish_db.get("id"));

                given()
                .when()
                .delete("/dishes/"+deleted_dish_ID);

            System.out.println("Dish["+dish_massive_size+"]: "+dish_db.get("name")+
                    "\t id: "+  dish_db.get("id")+ " is DELETED");
            dish_massive_size --;
        }
    }

    @Test(enabled = true)
    public void addCucumber() {
        for (int i = 0; i<3; i++) {

                given().body("{\n" +
                "  \"name\":\"Cucumber1\",\n" +
                "  \"price\": 9,\n" +
                "  \"currency\":\"US\"\n" +
                "}")
                .contentType(ContentType.JSON)
                .when()
                .post("/dishes")
                .then()
                .statusCode(200);
        }
    }

    @Test(enabled = true)
    public void get_PrintPrettty_dishes_by_ID() {
        //Response res =  given()
                given()
                .when()
                .get("/dishes/5b1fb4cc4e749dec8817db5c")
                .then()
                .statusCode(200);

        //System.out.println(res.body().prettyPrint());
    }

    @Test(enabled = true)
    public void get_dishes_by_ID() {
                        given()
                        .when()
                        .contentType(ContentType.JSON)
                        .get("/dishes/5b1e99d42548d06378fe20a6")
                        .then()
                        .statusCode(200);

    }

    @Test(enabled = true)
    public void addDishes1() {
        given().body("{ \n" +
                "\"name\":\"Dish_1\",\n" +
                "  \"price\": 7,\n" +
                "  \"currency\": \"US\"\n" +
                "}")
                .contentType(ContentType.JSON)
                .post("/dishes")
                .then()
                .statusCode(200);
    }

    @Test
    public void post_Request_for_Dishes() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Strawberry_string994");
        requestBody.put("price", 9);
        requestBody.put("currency", "US");

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());
        Response response = request.post("/dishes");

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
        requestBody.put("first_name", "Wonder");
        requestBody.put("last_name", "woman");
        requestBody.put("staff_position", "hero");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());
        Response response = request.post("/staffs");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        String successCode = response.jsonPath().get("SuccessCode");
        System.out.println("Status Code is : " + statusCode);
        System.out.println(response.getBody().asString());
    }

    @Test
    public void postRequestExampleItemsItemsDB() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "spider33");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());
        Response response = request.post("http://localhost:3000/api/items");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        String successCode = response.jsonPath().get("SuccessCode");
        System.out.println("Status Code is : " + statusCode);
        System.out.println(response.getBody().asString());
    }
}
