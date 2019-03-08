package api.helpers;

import api.POJO.Records;
import api.POJO.Staffs;
import cucumber.api.DataTable;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class MainMethods {
    public static Response response;
    static List<Staffs.Staff> staffs;
    static List<Records.Record> records;
    static String body, entityStaffId, uId;
    static int arraySize, currentElement;
    public static ArrayList<String> idArray = new ArrayList<>();

    public static Response requestGenerator(String endPoint, String httpVerb, String entityKey, DataTable table) {

        if (entityKey.equals("Staff")) {
            staffs = table.asList(Staffs.Staff.class);
            JSONObject requestBody = new JSONObject();
            for (Staffs.Staff staff : staffs) {
                body = JsonObjectConstructor.makeStaffJsonObject(requestBody, staff).toString();
                response = RequestConstructor.requestCompiler(endPoint, httpVerb, body, "someID");
                entityStaffId = response.jsonPath().get("id").toString();
                idArray.add(entityStaffId);
                arraySize = idArray.size();
                currentElement = arraySize-1;
                uId = idArray.get(currentElement);
                System.out.println("******> entityStaffId[" + (currentElement) + "]: " + uId);
            }
        } else if (entityKey.equals("Record")) {
            records = table.asList(Records.Record.class);
            JSONObject requestBody = new JSONObject();
            for (Records.Record record : records) {
                JSONObject createdBody = JsonObjectConstructor.makeRecordJsonObject(requestBody, record);
                body = createdBody.toString();
                response = RequestConstructor.requestCompiler(endPoint, httpVerb, body, "id");
            }
        } else {
            System.out.println(Resources.defaultRequestWarning());
        }
        return response;
    }

    public static void responseParameterValidator(String referenceParameter, String referenceValue) {
        System.out.println("\n****** > referenceParameter: " + referenceParameter + " | referenceValue: " + referenceValue);
        String extraContentType = "; charset=utf-8";
        switch (referenceParameter) {
            case "StatusCode":
                String responseStatusCode = String.valueOf(response.getStatusCode());
                Assert.assertEquals(referenceParameter + " was not returned", responseStatusCode, referenceValue);
                break;
            case "SuccessCode":
                String successCode = response.jsonPath().get("SuccessCode");
                System.out.println("successCode " + successCode);
                Assert.assertEquals(referenceParameter + "was not returned", successCode, "OPERATION_SUCCESS");
                break;
            case "contentType":
                String contentType = response.jsonPath().get("content-type");
                System.out.println("contentType: " + contentType);
                Assert.assertEquals(referenceParameter + "was not returned", contentType, referenceValue + extraContentType);
                break;
            default:
                System.out.println("Please check parameters for 'responseParameterValidator' method ");
        }
    }
}

