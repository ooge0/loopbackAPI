package api.POJO;


import java.util.HashMap;
import java.util.Map;

public class RecordsNestedObj {

    public class Record {
        public String relationType;

        public class RecordRelation {

            public String relationType;
            private Map<String, Object> additionalProperties = new HashMap<String, Object>();

            public Map<String, Object> getAdditionalProperties() {
                return this.additionalProperties;
            }

            public void setAdditionalProperty(String name, Object value) {
                this.additionalProperties.put(name, value);

            }
        }
    }
}
