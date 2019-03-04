package api.helpers;

import api.POJO.Records;
import api.POJO.Staffs;
import cucumber.api.DataTable;
import org.json.JSONObject;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MainMethods {


    public static String bodyEntityGenerator(String entityName,  DataTable table) {
        JSONObject requestBody = new JSONObject();
        String requestBodyAsString = null;
        if (entityName == "Staff") {
            //create an ArrayList
            List<Staffs.Staff> entities;
            //store all items from selected entity
            entities = table.asList(Staffs.Staff.class);
            //create FOR cycle for each elements of List<Staffs>
            for (Staffs.Staff entity : entities) {
                requestBody = new JSONObject();
                requestBody.put("first_name", entity.first_name);
                requestBody.put("last_name", entity.last_name);
                requestBody.put("staff_position", entity.staff_position);
                requestBody.put("starship", entity.starship);
            }
        } else if (entityName == "Record") {
            //create an ArrayList
            List<Records.Record> entities;
            //store all items from selected entity
            entities = table.asList(Records.Record.class);
            //create FOR cycle for each elements of List<Staffs>
            for (Records.Record entity : entities) {
                requestBody = new JSONObject();
                requestBody.put("recordIdItem", entity.recordIdItem);
                requestBody.put("recordLabelItem", entity.recordLabelItem);
                requestBody.put("recordCreationDataItem", entity.recordCreationDataItem);
                requestBody.put("recordRelationItem", entity.recordRelationItem);
                requestBody.put("recordOwnerItem", entity.recordOwnerItem);
                requestBody.put("recordStatusItem", entity.recordStatusItem);
                requestBody.put("idItem", entity.idItem);
            }

        } else {
            System.out.println(Resources.defaultRequestWarning());
        }
        requestBodyAsString = requestBody.toString();
        return requestBodyAsString;
    }
}
