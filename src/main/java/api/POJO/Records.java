package api.POJO;


public class Records {

    public class Record {
        public int recordId;
        public String recordLabel;
        public String recordCreationData;
        public String recordRelation;
        public String recordOwner;
        public boolean recordStatus;

        public Record(int recordId, String recordLabel, String recordCreationData, String recordRelation, String recordOwner, boolean recordStatus) {
            this.recordId = recordId;
            this.recordLabel = recordLabel;
            this.recordCreationData = recordCreationData;
            this.recordRelation = recordRelation;
            this.recordOwner = recordOwner;
            this.recordStatus = recordStatus;
        }
    }
}

