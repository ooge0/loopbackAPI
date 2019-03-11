package api.POJO;


public class Staffs {

    public class Staff {
        public String first_name;
        public String last_name;
        public String staff_position;
        public String starship;

        public Staff(String firstName, String lastName, String staffPositon, String starShip) {
            first_name = firstName;
            last_name = lastName;
            staff_position = staffPositon;
            starship = starShip;
        }
    }

}
