package api.stepDefinitions;

import api.helpers.staffs.BasicMethodsStaffs;
import api.helpers.staffs.FunctionsStaffs;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

public class StepDefenitions {


    @When("^I add one staff item in background$")
    public void iADDOneStaffItemInBackground() {
        FunctionsStaffs.addingStaffBackground();

    }

    @Then("^I check existing of the Staff list$")
    public void i_check_existing_of_the_staff_list() {
        FunctionsStaffs.checkingExistedStaffList();
    }

    @And("^I check response and it has StatusCode (\\d+) and contentType: ([^\\\"]*)$")
    public void iCheckRessponseAndItHasStatusCodeAndContentTypeApplicationJson(int status_code, String content_type) {
        FunctionsStaffs.checkingResponseStatusCode(status_code, content_type);
    }

    @And("I print information about Staff list")
    public void get_prettyPrint_of_staff_list() {
        BasicMethodsStaffs.printingStaffList();
    }


    @Then("^I delete all records from the Staff list$")
    public void i_delete_all_records_from_staff_list() {
        FunctionsStaffs.deleteAllStaffs();
    }

    @And("^I check that staff list and it contains (\\d+) item$")
    public void i_check_staff_list_is_empty(int list_value) {
        BasicMethodsStaffs.listSize(list_value);

    }

    @And("^I check the Staff list and statusCode is (\\d+)$")
    public void checking_StatusCode_Response_(int verification_status_code) {
        BasicMethodsStaffs.checkingResponseStatusCode(verification_status_code);
    }

    @And("^I add one staff record as ([^\\\"]*), ([^\\\"]*), ([^\\\"]*), ([^\\\"]*)$")

    public void I_add_new_one_staff_record(String first_name, String last_name, String staff_positon, String starship) {
        FunctionsStaffs.addNewStaffRecord(first_name, last_name, staff_positon, starship);
    }


    @And("^I add staff records$")
    public void iAddNextItems(DataTable table) {
        FunctionsStaffs.addSomeStaffRecords(table);
    }


    @And("^I check that list contains (\\d+) items$")
    public void checking_staff_records_size(int staff_size_list) {
        BasicMethodsStaffs.listSize(staff_size_list);
    }

    @And("^I check that last request has statusCode: (\\d+)$")
    public void status_code_validation(int status_code) {
        BasicMethodsStaffs.statusCodeValidation(status_code);
    }

    @And("^I check that (\\d+) record has name and it has next positon$")
    public void iCheckThatHeroHasNameAndItHasPositon(int hero_position, DataTable table) {
        FunctionsStaffs.checkingPositionAndName(hero_position, table);
    }

    @And("^I print the Staff list$")
    public void iPrintStaffList() {
        FunctionsStaffs.printingRecordsList();
    }


    @When("^I delete (\\d+) and (\\d+) item from DB$")
    public void iDeleteAndItemFromDB(int first_item, int last_item) {
        FunctionsStaffs.deletingRecords(first_item, last_item);

    }

    @Then("^I check that staff list contains (\\d+) item$")
    public void iCheckThatDBContainsOnlyItem(int staff_size_list) {
        BasicMethodsStaffs.listSize(staff_size_list);
    }

    @And("^I check that last item has name and position$")
    public void thisItemHasNameAndPosition(DataTable table) {
        FunctionsStaffs.checkingLastRecordNamePosition(table);
    }

}
