package api.POJO;


public class Staffs {

    public class Staff {
        public String firstName;
        public String lastName;
        public String staffPosition;
        public String starship;

        public Staff(String firstName, String lastName, String staffPositon, String starShip) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.staffPosition = staffPositon;
            this.starship = starShip;
        }
    }

}
