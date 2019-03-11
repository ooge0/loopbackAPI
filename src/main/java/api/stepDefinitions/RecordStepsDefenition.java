package api.stepDefinitions;

import api.helpers.BasicMethods;
import api.helpers.MainMethods;
import api.helpers.RequestConstructor;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;

public class RecordStepsDefenition {
    String endPoint, httpVerb, entityName;
    static Response response;

    @Given("^I'm working with ([^\\\"]*) entity$")
    public void recordEntityInitialization(String entity) {
        entityName = entity.toLowerCase();
        endPoint = BasicMethods.gettingEndPoint(entity);
    }


    @And("^I (add|delete|check) new '(Record|Staff)' and store id for each entity$")
    public void addingNewEntities(String actionWord, String entityKey, DataTable table) {
        httpVerb = BasicMethods.gettingHttpVerb(actionWord);
        response = MainMethods.requestGenerator(endPoint, httpVerb, entityKey, table);
    }


    @And("^I check that (StatusCode|SuccessCode|contentType) is '([^\\\"]*)'$")
    public void checkingResponseParameters(String referenceParameter, String referenceValue) {
        MainMethods.responseParameterValidator(referenceParameter, referenceValue);
    }


    @Then("^I (add|delete|check) an existed Records$")
    public void checkingExistedStaffRecord(String actionWord) {
        httpVerb = BasicMethods.gettingHttpVerb(actionWord);
        RequestConstructor.requestCompiler(endPoint, httpVerb, " ", " ");
   }

    @Then("^I checked that collection isn't empty$")
    public void checkingCollection() {
        RequestConstructor.checkingExistingCollection();
    }

}

