package api.stepDefinitions;

import api.helpers.BasicMethods;
import api.helpers.MainMethods;
import api.helpers.RequestConstructor;
import api.helpers.staffs.FunctionsStaffs;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class RecordStepsDefenition {
     String endPoint, httpVerb,entityName ;

    @Given("^I'm working with ([^\\\"]*) entity$")
    public void recordEntityInitialization(String entity)  {
        entityName = entity.toLowerCase();
        endPoint = BasicMethods.gettingEndPoint(entity);
    }


    @And("^I (add|delete|check) new '(Record|Staff)'$")
    public void addingNewEntities(String actionWord, String entityKey, DataTable table) {
        httpVerb = BasicMethods.gettingHttpVerb(actionWord);
        MainMethods.requestGenerator(endPoint,httpVerb,entityKey, table);
    }


    @And("^I check response and it has StatusCode (\\d+) and contentType: ([^\\\"]*)$")
    public void checkingResponseStatusCodeContentType(int status_code, String content_type) {
        FunctionsStaffs.checkingItemResponseStatusCode(status_code, content_type);
    }


    @Then("^I (add|delete|check) an existed Records$")
    public void checkingExistedStaffRecord(String actionWord) {
        httpVerb = BasicMethods.gettingHttpVerb(actionWord);
        RequestConstructor.requestCompiler(endPoint, httpVerb, " ", " ");
        RequestConstructor.checkingExistingCollection();

    }
}

