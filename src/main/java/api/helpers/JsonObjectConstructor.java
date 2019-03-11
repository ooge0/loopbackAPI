package api.helpers;

import api.POJO.Records;
import api.POJO.Staffs;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonObjectConstructor {

    public static JSONObject makeStaffJsonObject(JSONObject requestBody, Staffs.Staff staff) {
        {
            requestBody.put("firstName", staff.firstName);
            requestBody.put("lastName", staff.lastName);
            requestBody.put("staffPosition", staff.staffPosition);
            requestBody.put("starship", staff.starship);
        }
        return requestBody;
    }

    public static JSONObject makeRecordJsonObject(JSONObject requestBody, Records.Record record) {
        JSONObject jo = new JSONObject();
        String relationTypeValue =  record.recordRelation;
        jo.put("relationType", relationTypeValue);
        JSONArray ja = new JSONArray();
        ja.put(jo);
        {
            requestBody.put("recordId", record.recordId);
            requestBody.put("recordLabel", record.recordLabel);
            requestBody.put("recordCreationData", record.recordCreationData);
            requestBody.put("recordRelation", ja);
            requestBody.put("recordOwner", record.recordOwner);
            requestBody.put("recordStatus", record.recordStatus);
        }
        return requestBody;
    }


}
