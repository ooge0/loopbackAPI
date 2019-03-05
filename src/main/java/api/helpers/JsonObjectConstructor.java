package api.helpers;

import api.POJO.Records;
import api.POJO.Staffs;
import org.json.JSONObject;

public class JsonObjectConstructor {

    public static JSONObject makeStaffJsonObject(JSONObject requestBody, Staffs.Staff staff) {
        {
            requestBody.put("first_name", staff.first_name);
            requestBody.put("last_name", staff.last_name);
            requestBody.put("staff_position", staff.staff_position);
            requestBody.put("starship", staff.starship);
        }
        return requestBody;
    }

    public static JSONObject makeRecordJsonObject(JSONObject requestBody, Records.Record record) {
        {
            requestBody.put("recordIdItem", record.recordIdItem);
            requestBody.put("recordLabelItem", record.recordLabelItem);
            requestBody.put("recordCreationDataItem", record.recordCreationDataItem);
            requestBody.put("recordRelationItem", record.recordRelationItem);
            requestBody.put("recordOwnerItem", record.recordOwnerItem);
            requestBody.put("recordStatusItem", record.recordStatusItem);
            requestBody.put("idItem", record.idItem);
        }
        return requestBody;
    }

}
