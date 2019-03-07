package api.POJO;

public class Records {

    public class Record {
        public int recordIdItem;
        public String recordLabelItem;
        public String recordCreationDataItem;
        public String[] recordRelationItem;
        public String recordOwnerItem;
        public boolean recordStatusItem;

        public Record(int recordId, String recordLabel, String recordCreationData, String[] recordRelation, String recordOwner, boolean recordStatus) {
            recordIdItem = recordId;
            recordLabelItem = recordLabel;
            recordCreationDataItem = recordCreationData;
            recordRelationItem = recordRelation;
            recordOwnerItem = recordOwner;
            recordStatusItem = recordStatus;
        }
    }
}

