package api.helpers;
import api.POJO.Records;
import api.POJO.Staffs;
import cucumber.api.DataTable;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;

import javax.xml.ws.Response;
import java.util.List;

import static api.helpers.JsonObjectConstructor.makeRecordJsonObject;
import static api.helpers.JsonObjectConstructor.makeStaffJsonObject;

public class MainMethods {
    static String body = null;
    static RequestSpecification response;

    public static Response requestGenerator(String endPoint, String httpVerb, String entityKey, DataTable table) {
        JSONObject requestBody = new JSONObject();
        if (entityKey == "Staff") {
            //create an ArrayList
            List<Staffs.Staff> staffs;
            //store all items from selected entity
            staffs = table.asList(Staffs.Staff.class);
            //create FOR cycle for each elements of List<Staffs>
            for (Staffs.Staff staff : staffs) {
                body = JsonObjectConstructor.makeStaffJsonObject(requestBody, staff).toString();
                response = RequestConstructor.requestCompiler(endPoint, httpVerb, body, null);

            }
        } else if (entityKey == "Record") {
            List<Records.Record> records;
            records = table.asList(Records.Record.class);
            for (Records.Record record : records) {
                body = JsonObjectConstructor.makeRecordJsonObject(requestBody, record).toString();
                response = RequestConstructor.requestCompiler(endPoint, httpVerb, body, null);
            }

        } else {
            System.out.println(Resources.defaultRequestWarning());
        }

        return (Response) response;
    }

//    public responseValidation(Response response) {
//
//        int statusCode = response.getStatusCode();
//        Assert.assertEquals(statusCode, "201");
//        String successCode = response.jsonPath().get("SuccessCode");
//        Assert.assertEquals("Correct Success code was returned", successCode, "OPERATION_SUCCESS");
//    }
}

