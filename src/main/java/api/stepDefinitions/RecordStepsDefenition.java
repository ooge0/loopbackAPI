package api.stepDefinitions;

import api.helpers.BasicMethods;
import api.helpers.MainMethods;
import api.helpers.RequestConstructor;
import api.helpers.staffs.FunctionsStaffs;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class RecordStepsDefenition {
    static String endPoint, httpVerb,entityName, responseBody, requestBody ;

    @Given("^I'm working with ([^\\\"]*) entity$")
    public void recordEntityInitialization(String entity) throws Throwable {
        entityName = entity.toLowerCase();
        endPoint = BasicMethods.gettingEndPoint(entity);
        throw new PendingException();
    }


    @And("^I (add|delete|check) new '(Record|Staff)'$")
    public void addingNewEntities(String actionWord, String key, DataTable table) {
        httpVerb = BasicMethods.gettingHttpVerb(actionWord);
        requestBody = MainMethods.bodyEntityGenerator(entityName, table);
        if (key == "Record") {
            RequestConstructor.requestGenerator(endPoint, httpVerb, requestBody,null);
        } else if (key == "Staff") {
            FunctionsStaffs.addSomeStaffRecords(table);
        }
    }


    @And("^I check response and it has StatusCode (\\d+) and contentType: ([^\\\"]*)$")
    public void checkingResponseStatusCodeContentType(int status_code, String content_type) {
        FunctionsStaffs.checkingResponseStatusCode(status_code, content_type);
    }


    @Then("^I (add|delete|check) an existed Records$")
    public void checkingExistedStaffRecord(String actionWord) {
        FunctionsStaffs.checkingExistedStaffList();
        httpVerb = BasicMethods.gettingHttpVerb(actionWord);
        requestBody = "\"any { it.containsKey('first_name') }\", is(true)";
        RequestConstructor.requestGenerator(endPoint, httpVerb, requestBody,null);
    }
}

