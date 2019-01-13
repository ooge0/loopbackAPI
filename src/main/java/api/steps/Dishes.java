package api.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

public class Dishes {


    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;
    private String ENDPOINT_DISHES = "http://localhost:3000/api/dishes";
//    String ENDPOINT_DISHES = Resources.getEnvValue();
//    String st = "new";
    int dish_massive_size;
    int response_status_code;

    public Dishes() throws IOException {
    }

    @Given("^I check existing of the Dishes list$")
    public void i_check_existing_of_Dishes_list() {
        given()
                .when()
                .get(ENDPOINT_DISHES)
                .then().assertThat()
                .body("any { it.containsKey('name') }", is(true));

    }

    @And("^I check that it has StatusCode (\\d+) and contentType: ([^\\\"]*)$")
    public void i_check_existing_of_Dishes_list(int status_code, String content_type) {
        given()
                .when()
                .get(ENDPOINT_DISHES)
                .then().assertThat()
                .body("any { it.containsKey('name') }", is(true))
                .and()
                .statusCode(status_code)
                .contentType(content_type);

    }

    @And("I print information about Dishes list")
    public void get_prettyPrint_of_dishes() {
        request = given();
        response = request.when().get(ENDPOINT_DISHES);
    }

    @Then("I DELETE all dishes from the list and it contains (\\d+) item")
    public void delete_all_dishes_by_ID(int empty_list_value) {
        response = request.when().get(ENDPOINT_DISHES);
        List<Map<String, List<String>>> allDishes = response.jsonPath().getList("");
        dish_massive_size = 1; // allDishes.size()-allDishes.size()+1;

        for (Map<String, List<String>> dish_list : allDishes) {
            String deleted_dish_ID = String.valueOf(dish_list.get("id"));
            given()
                    .when()
                    .delete(ENDPOINT_DISHES + "/" + deleted_dish_ID).then()
                    .statusCode(200)
                    .and()
                    .body("count", equalTo(1));

            dish_massive_size++;
        }
        response = request.when().get(ENDPOINT_DISHES);

        allDishes = response.jsonPath().getList("");
        Assert.assertEquals(empty_list_value, allDishes.size());
    }

    @And("^I check the response and statusCode is (\\d+)$")
    public void iCheckResponseOfStatusCodeIs(int verification_status_code) throws Throwable {
        response = request.when().get(ENDPOINT_DISHES);
        response_status_code = response.getStatusCode();
        Assert.assertEquals(response_status_code, verification_status_code);

    }

    @And("^I ADD one item as ([^\\\"]*), (\\d+), ([^\\\"]*)$")
    public void iAddOneItemAsCucumberEU(String name, int price, String currency) throws Throwable {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", name);
        requestBody.put("price", price);
        requestBody.put("currency", currency);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());
        response = request.post(ENDPOINT_DISHES);
        response_status_code = response.getStatusCode();
        Assert.assertEquals(response_status_code, 200);

    }

    @And("^I check that dish list contains (\\d+) items")
    public void i_check_dish_list_size(int dish_size_list) {
        response = request.when().get(ENDPOINT_DISHES);
        List<Map<String, List<String>>> allDishes = response.jsonPath().getList("");
        Assert.assertEquals(dish_size_list, allDishes.size());

    }

    @Then("I ADD 4 dishes")
    public void i_add_next_items(DataTable table) {
        JSONObject requestBody = new JSONObject();
        //create an ArrayList
        List<Dish> dishes;
        //store all items
        dishes = table.asList(Dish.class);
        //create FOR cycle for each elements of List<Dish>
        for (Dish dish : dishes) {
            requestBody.put("name", dish.name);
            requestBody.put("price", dish.price);
            requestBody.put("currency", dish.currency);
            RequestSpecification request = RestAssured.given();
            request.header("Content-Type", "application/json");
            request.body(requestBody.toString());
            request.post(ENDPOINT_DISHES);
        }

    }

    @And("^I check list after adding a new items and it contains (\\d+) items$")
    public void iCheckThelistAndItContainsItems(int size_list) {
        response = request.when().get(ENDPOINT_DISHES);
        List<Map<String, List<String>>> allDishes = response.jsonPath().getList("");
        Assert.assertEquals(size_list, allDishes.size());
    }

    @And("^I check response of the statusCode is (\\d+)$")
    public void i_check_response_of_the_status_code_is(int status_code) {
        json = response.then().statusCode(status_code);
    }

    @And("^I check that (\\d+)st item has name, price and currency$")
    public void i_check_that_this_item_has_name_price_and_currency(int dish_position, DataTable table) {
        response = request.when().get(ENDPOINT_DISHES);
        List<Map<String, List<String>>> allDishes = response.jsonPath().getList("");
        List<Dish> dishes;
        //store all items
        dishes = table.asList(Dish.class);
        for (Dish dish : dishes) {
            assertEquals((allDishes.get(dish_position - 1).get("name")), dish.name);
            assertEquals((allDishes.get(dish_position - 1).get("price")), dish.price);
            assertEquals((allDishes.get(dish_position - 1).get("currency")), dish.currency);
        }

    }

    @When("^I delete (\\d+) and (\\d+) item from the list$")
    public void iDeleteAndItemFromlist(int first_item, int last_item) {
        int item_position_first = first_item - 1;
        int item_position_last = last_item - 1;
        List<Map<String, List<String>>> allDishes = response.jsonPath().getList("");
        // int dish_massive_size = allDishes.size();
        String first_delete_ID_item = String.valueOf(allDishes.get(item_position_first).get("id"));
        given()
                .when()
                .delete(ENDPOINT_DISHES + "/" + first_delete_ID_item).then()
                .statusCode(200)
                .and()
                .body("count", equalTo(1));

        response = request.when().get(ENDPOINT_DISHES);
        allDishes = response.jsonPath().getList("");
        String last_delete_ID_item = String.valueOf(allDishes.get(item_position_last).get("id"));
        given()
                .when()
                .delete(ENDPOINT_DISHES + "/" + last_delete_ID_item).then()
                .statusCode(200)
                .and()
                .body("count", equalTo(1));
    }

    @Then("^I check that the list contains (\\d+) items$")
    public void iCheckThatlistContainsItem(int size_list) {
        response = request.when().get(ENDPOINT_DISHES);
        List<Map<String, List<String>>> allDishes = response.jsonPath().getList("");
        Assert.assertEquals(size_list, allDishes.size());
    }

    @When("^I ADD one new dish$")
    public void iAddNewDishes(DataTable table) {
        response = request.when().get(ENDPOINT_DISHES);
        JSONObject requestBody = new JSONObject();
        //create an ArrayList
        List<Dish> dishes;
        //store all items
        dishes = table.asList(Dish.class);
        //create FOR cycle for each elements of List<Dish>
        for (Dish dish : dishes) {
            requestBody.put("name", dish.name);
            requestBody.put("price", dish.price);
            requestBody.put("currency", dish.currency);

            RequestSpecification request = RestAssured.given();
            request.header("Content-Type", "application/json");
            request.body(requestBody.toString());
            request.post(ENDPOINT_DISHES);
        }
    }

    @And("^I check that final list contains (\\d+) items$")
    public void iCheckThatFinalListContainsItems(int size_list) {
        response = request.when().get(ENDPOINT_DISHES);
        List<Map<String, List<String>>> allDishes = response.jsonPath().getList("");
        Assert.assertEquals(size_list, allDishes.size());
    }


    public class Dish {
        public String name;
        public int price;
        public String currency;

        Dish(String dishName, int dishPrice, String dishCurrency) {
            name = dishName;
            price = dishPrice;
            currency = dishCurrency;
        }
    }

}
