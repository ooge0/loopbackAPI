package api.helpers;

import api.POJO.Records;
import api.POJO.Staffs;
import cucumber.api.DataTable;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class MainMethods {
    static Response response;
    static List<Staffs.Staff> staffs;
    static List<Records.Record> records;
    static int response_status_code;

    public static Response requestGenerator(String endPoint, String httpVerb, String entityKey, DataTable table) {

        if (entityKey.equals("Staff")) {
            String body;
            staffs = table.asList(Staffs.Staff.class);
            JSONObject requestBody = new JSONObject();
            for (Staffs.Staff staff : staffs) {
                body = JsonObjectConstructor.makeStaffJsonObject(requestBody, staff).toString();
                System.out.println("\n***** requestGenerator ****** \nendPoint: "+endPoint+ "\nhttpVerb: " + httpVerb +"\nbody: " + body+"\n***** requestGenerator ******\n");
                RequestConstructor.requestCompiler(endPoint, httpVerb, body, "someID");
              //  System.out.println("response: " + response.toString());
//                response_status_code = response.getStatusCode();
//                assertEquals(response_status_code, 200);
            }
        } else if (entityKey.equals("Record")) {
            records = table.asList(Records.Record.class);
            String body;
            JSONObject requestBody = new JSONObject();
            for (Records.Record record : records) {
                JSONObject createdBody = JsonObjectConstructor.makeRecordJsonObject(requestBody, record);
                body = createdBody.toString();
                RequestConstructor.requestCompiler(endPoint, httpVerb, body, "id");

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

