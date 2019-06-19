package tests;

import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import model.people.People;
import model.people.UserAddress;
import org.assertj.core.api.SoftAssertions;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.jayway.restassured.http.ContentType.JSON;

public class PeopleCreation {
    int stCode;
    String idPeopleCreated;
    String peopleJsonResponse;
    String baseUrl = "http://localhost:3000/api/people";
    Gson gson = new Gson();

    @Test
    public void peopleEntityCreation() {
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

    @Test
    public void peopleEntityChecking() {
        Response response = getResponse();
        String peopleFullList = response.asString();
        People[] peopleArray = gson.fromJson(peopleFullList, People[].class);
        HashMap<String, String> peopleEntityCollection = new HashMap<String, String>();
        List<String> peopleIdList = new ArrayList<String>();
        for (People peopleRecord : peopleArray) {
            System.out.println("name: " + peopleRecord.getName() + "\tid: " + peopleRecord.getId());
            peopleEntityCollection.put(peopleRecord.getId(), peopleRecord.getName());
            peopleIdList.add(peopleRecord.getId());
        }
        System.out.println("\npeopleIdList: " + peopleIdList);
        getStatusCode(response);
        AssertJUnit.assertEquals(200, stCode);
        for (HashMap.Entry<String, String> entry : peopleEntityCollection.entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }
        System.out.println("\npeopleEntityCollection: " + peopleEntityCollection);
    }

    @Test
    public void peopleDeleteFirstEntity() {
        peopleEntityChecking();
        Response response = getResponse();
        String peopleFullList = response.asString();
        People[] peopleArray = gson.fromJson(peopleFullList, People[].class);
        for (People peopleRecord : peopleArray) {
            System.out.println("name: " + peopleRecord.getName() + "\tid: " + peopleRecord.getId());
        }
        getStatusCode(response);
        AssertJUnit.assertEquals(200, stCode);
    }

    @Test
    public void peopleCreationDeletion() {
        String peopleBodyRequest = gson.toJson(peopleObject);
        Response response = postResponse(peopleBodyRequest, baseUrl);
        peopleJsonResponse = response.asString();
        getStatusCode(response);
        People peopleObj = gson.fromJson(peopleJsonResponse, People.class);
        idPeopleCreated = peopleObj.getId();
        response = RestAssured.given()
                .contentType(JSON)

                .get("http://localhost:3000/api/people/" + idPeopleCreated);
        getStatusCode(response);
        AssertJUnit.assertEquals(200, stCode);
//        System.out.println("\nGET 1st:\nstCode: " + stCode);

        response = RestAssured.given()
                .contentType(JSON)
                .get("http://localhost:3000/api/people/");
        String peopleFullList = response.asString();
        People[] peopleArray = gson.fromJson(peopleFullList, People[].class);
        HashMap<String, String> peopleEntityCollection = new HashMap<String, String>();
        List<String> peopleIdList = new ArrayList<String>();
        for (People peopleRecord : peopleArray) {
            peopleEntityCollection.put(peopleRecord.getId(), peopleRecord.getName());
            peopleIdList.add(peopleRecord.getId());
        }
        System.out.println("\npeopleIdList: " + peopleIdList);
        getStatusCode(response);
        AssertJUnit.assertEquals(200, stCode);
        String deletedId = peopleIdList.get(peopleIdList.size()-1);
        response = RestAssured.given()
                .contentType(JSON)
                .delete("http://localhost:3000/api/people/" + deletedId);
        getStatusCode(response);
        AssertJUnit.assertEquals(200, stCode);
        System.out.println("\nDELETE :\ndeleted id: "+deletedId+"\nstCode: " + stCode);

        response = RestAssured.given()
                .contentType(JSON)
                .get("http://localhost:3000/api/people/");
        peopleFullList = response.asString();
        peopleArray = gson.fromJson(peopleFullList, People[].class);
        peopleEntityCollection = new HashMap<String, String>();
        peopleIdList = new ArrayList<String>();
        for (People peopleRecord : peopleArray) {
            peopleEntityCollection.put(peopleRecord.getId(), peopleRecord.getName());
            peopleIdList.add(peopleRecord.getId());
        }
//        System.out.println("\npeopleIdList: " + peopleIdList);
        getStatusCode(response);
        AssertJUnit.assertEquals(200, stCode);
//        System.out.println("\nGET full list:\nstCode: " + stCode);
    }

    private void getStatusCode(Response response) {
        stCode = response.getStatusCode();
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

    private Response getResponse() {
        return RestAssured.given()
                .contentType(JSON)
                .get("http://localhost:3000/api/people/");
    }

    private Response postResponse(String peopleBodyRequest, String url) {
        return RestAssured.given()
                .contentType(JSON)
                .body(peopleBodyRequest)
                .post(url);
    }
}
