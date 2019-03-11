package api.helpers;

import api.POJO.Records;
import api.POJO.Staffs;
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

        {
            requestBody.put("recordIdItem", record.recordIdItem);
            requestBody.put("recordLabelItem", record.recordLabelItem);
            requestBody.put("recordCreationDataItem", record.recordCreationDataItem);
            requestBody.put("recordRelationItem", record.recordRelationItem[0]);
            requestBody.put("recordOwnerItem", record.recordOwnerItem);
            requestBody.put("recordStatusItem", record.recordStatusItem);
        }
        return requestBody;
    }

}
