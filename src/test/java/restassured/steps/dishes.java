package restassured.steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.StringContains.containsString;

public class dishes {


    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;
    private String ENDPOINT_DISHES = "http://localhost:3000/api/dishes";
    int dish_massive_size;
    int response_status_code;
    int size_list;


    @Given("^I check Dishes list")
    public void iCheckDishesDB() {
        request = given();

    }

    @And("I print information about Dishes list")
    public void get_prettyPrint_of_dishes() {
        request = given();
        response = request.when().get(ENDPOINT_DISHES);
        System.out.println("response: " + response.prettyPrint());

    }

    @Then("I delete all dishes from the list and it contains (\\d+) item")
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

            System.out.println("\nDish[" + dish_massive_size + "]: " + dish_list.get("name") + " id: " + dish_list.get("id") + " is DELETED");
            dish_massive_size++;
        }
        response = request.when().get(ENDPOINT_DISHES);

        allDishes = response.jsonPath().getList("");
        System.out.println("\nDishes list contains: " + allDishes.size() + " items after deleting of all items");
        Assert.assertEquals(empty_list_value, allDishes.size());
    }

    @And("^I check response of the statusCode is (\\d+)$")
    public void iCheckResponseOfStatusCodeIs(int verification_status_code) throws Throwable {
        //json = response.then().statusCode(status_code);
        response = request.when().get(ENDPOINT_DISHES);
        response_status_code = response.getStatusCode();
        Assert.assertEquals(response_status_code, verification_status_code);

    }

    @And("^I add one item as ([^\\\"]*), (\\d+), ([^\\\"]*)$")
    public void iAddOneItemAsCucumberEU(String name, int price, String currency) throws Throwable {
        System.out.println("\nI add one item as: cucumber, 1, EU \n");
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", name);
        requestBody.put("price", price);
        requestBody.put("currency", currency);

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());
        response = request.post(ENDPOINT_DISHES);

//        Response response = request.post("/dishes");
        //json = response.then().statusCode(200);
        response_status_code = response.getStatusCode();
        Assert.assertEquals(response_status_code, 200);

    }

    @And("^I check that list contains (\\d+) items")
    public void iCheckTheDBSize(int size_list) {
        response = request.when().get(ENDPOINT_DISHES);
        List<Map<String, List<String>>> allDishes = response.jsonPath().getList("");
        System.out.println("Dish list contains: " + allDishes.size() + " items.\n");
        Assert.assertEquals(size_list, allDishes.size());

    }

    @Then("I add several dishes")
    public void i_add_next_items(DataTable table) {
        JSONObject requestBody = new JSONObject();
        System.out.println("I add several dishes.");
        //create an ArrayList
        List<Dish> dishes;
        //store all items
        dishes = table.asList(Dish.class);
        //create FOR cycle for each elements of List<Dish>
        for (Dish dish : dishes) {
            System.out.println("\n name: " + dish.name + ", price: " + dish.price + ", currency: " + dish.currency);

            requestBody.put("name", dish.name);
            requestBody.put("price", dish.price);
            requestBody.put("currency", dish.currency);

            RequestSpecification request = RestAssured.given();
            request.header("Content-Type", "application/json");
            request.body(requestBody.toString());
            request.post(ENDPOINT_DISHES);
        }
        // throw new PendingException();
    }

    @And("^I check list after adding a new items and it contains (\\d+) items$")
    public void iCheckThelistAndItContainsItems(int size_list) {
        response = request.when().get(ENDPOINT_DISHES);
        List<Map<String, List<String>>> allDishes = response.jsonPath().getList("");
        System.out.println("\nI check list after adding and it contains: " + allDishes.size() + " items.\n");
        Assert.assertEquals(size_list, allDishes.size());
    }

    @And("^I check the statusCode is (\\d+)$")
    public void iCheckTheStatusCodeIs(int status_code) {
        json = response.then().statusCode(status_code);
    }

    @And("^I check that (\\d+) st items has name, price and currency$")
    public void iCheckThatStItemsHasNamePriceAndCurrency(int item_position, DataTable table) {
        response = request.when().get(ENDPOINT_DISHES);
        System.out.println("I check that selected item has " + item_position + " position.");

        List<Map<String, List<String>>> allDishes = response.jsonPath().getList("");
        List<Dish> dishes;

        //store all items
        dishes = table.asList(Dish.class);
        System.out.println("\nI check 1st item. Its name is : " + allDishes.get(item_position - 1).get("name"));
        for (Dish dish : dishes) {
            System.out.println("\n name: " + dish.name + ", price: " + dish.price + ", currency: " + dish.currency);
        }

    }

    @When("^I delete (\\d+) and (\\d+) item from the list$")
    public void iDeleteAndItemFromlist(int first_item, int last_item) {
        int item_position_first = first_item - 1;
        int item_position_last = last_item - 1;
        List<Map<String, List<String>>> allDishes = response.jsonPath().getList("");
        int dish_massive_size = allDishes.size();
        System.out.println("\nI choose 1st Dish: " + "\t name: " + allDishes.get(item_position_first).get("name")
                + "\t id: " + allDishes.get(item_position_first).get("id"));
        String first_delete_ID_item = String.valueOf(allDishes.get(item_position_first).get("id"));
        given()
                .when()
                .delete(ENDPOINT_DISHES + "/" + first_delete_ID_item).then()
                .statusCode(200)
                .and()
                .body("count", equalTo(1));

        response = request.when().get(ENDPOINT_DISHES);
        allDishes = response.jsonPath().getList("");
        System.out.println("\nI choose 2nd Dish: " + "\t name: " + allDishes.get(item_position_last).get("name")
                + "\t id: " + allDishes.get(item_position_last).get("id"));

        String last_delete_ID_item = String.valueOf(allDishes.get(item_position_last).get("id"));

        given()
                .when()
                .delete(ENDPOINT_DISHES + "/" + last_delete_ID_item).then()
                .statusCode(200)
                .and()
                .body("count", equalTo(1));


    }

    @Then("^I check that the list contains only (\\d+) item$")
    public void iCheckThatlistContainsOnlyItem(int size_list) {
        response = request.when().get(ENDPOINT_DISHES);
        List<Map<String, List<String>>> allDishes = response.jsonPath().getList("");
        System.out.println("\nDish list contains: " + allDishes.size() + " items.\n");
        Assert.assertEquals(size_list, allDishes.size());
    }

    @When("^I add new dishes$")
    public void iAddNewDishes(DataTable table) {
        response = request.when().get(ENDPOINT_DISHES);
        JSONObject requestBody = new JSONObject();
        System.out.println("I only one dish.");
        //create an ArrayList
        List<Dish> dishes;
        //store all items
        dishes = table.asList(Dish.class);
        //create FOR cycle for each elements of List<Dish>
        for (Dish dish : dishes) {
            System.out.println("\n name: " + dish.name + ", price: " + dish.price + ", currency: " + dish.currency);

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
        System.out.println("\nDish list contains: " + allDishes.size() + " items.\n");
        Assert.assertEquals(size_list, allDishes.size());
    }


    public class Dish {
        public String name;
        public String price;
        public String currency;

        Dish(String dishName, String dishPrice, String dishCurrency) {
            name = dishName;
            price = dishPrice;
            currency = dishCurrency;
        }
    }

}
