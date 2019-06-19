package testNgTests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.AssertJUnit;

import static com.jayway.restassured.http.ContentType.JSON;

public class RestCall {
    @Test
    public void testRecordCreationFromJson() {
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
}
