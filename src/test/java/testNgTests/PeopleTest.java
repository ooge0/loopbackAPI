package testNgTests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import gherkin.deps.com.google.gson.Gson;
import model.people.People;
import model.people.UserAddress;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.testng.AssertJUnit;

import static com.jayway.restassured.http.ContentType.JSON;

public class PeopleTest {
    int stCode;
    String idPeopleCreated;
    String peopleJsonResponse;
    String baseUrl = "http://localhost:3000/api/people";
    Gson gson = new Gson();

    @Test
    public void PeopleEntityCreationFromJson() {
        String body = "{\n" +
                "  \"name\": \"defaultName\",\n" +
                "  \"email\": \"defaultEmail\",\n" +
                "  \"isDeveloper\": true,\n" +
                "  \"age\": 0,\n" +
                "  \"userAddress\": {\n" +
                "    \"city\": \"trueCity\",\n" +
                "    \"country\": \"trueCountry\",\n" +
                "    \"houseNumber\": 0,\n" +
                "    \"street\": \"trueStreet\"\n" +
                "  }\n" +
                "}";
        Response response = RestAssured.given()
                .contentType(JSON)
                .body(body)
                .post("http://localhost:3000/api/people");
        int stCode = response.getStatusCode();
        response.prettyPrint();

        AssertJUnit.assertEquals(200, stCode);

        response.prettyPrint();
    }
    @Test
    public void PeopleEntityCreationFromObject() {
        String peopleBodyRequest = gson.toJson(peopleObject);
        Response response = postResponse(peopleBodyRequest, baseUrl);
        peopleJsonResponse = response.asString();
        getStatusCode(response);

        People peopleObj = gson.fromJson(peopleJsonResponse, People.class);
        idPeopleCreated = peopleObj.getId();
        System.out.println("id: " + idPeopleCreated);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(stCode).isEqualTo(200);
        softly.assertThat(userAddress.getCity()).as("check  %s city", userAddress.getCity()).isEqualTo("Magdeburg");
        softly.assertThat(userAddress.getCountry()).as("check  %s country", userAddress.getCountry()).isEqualTo("Germany");
        softly.assertThat(userAddress.getHouseNumber()).as("check  %s houseNumber", userAddress.getHouseNumber()).isEqualTo("42A");
        softly.assertAll();
    }

    UserAddress userAddress = new UserAddress(
            "Main Street",
            "42A",
            "Magdeburg",
            "Germany"
    );

    People peopleObject = new People(
            "Norman",
            "norman@futurestud.io",
            26,
            true,
            userAddress
    );
    private void getStatusCode(Response response) {
        stCode = response.getStatusCode();
    }
    private Response postResponse(String peopleBodyRequest, String url) {
        return RestAssured.given()
                .contentType(JSON)
                .body(peopleBodyRequest)
                .post(url);
    }
}
