package model.people;

public class PeopleData {
    private String name;
    private  String email;
    private boolean isDeveloper;
    private int age;
    private UserAddress userAddress;
    private String id;

    public PeopleData() {

    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isDeveloper() {
        return isDeveloper;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public PeopleData withName(String name) {
        this.name = name;
        return this;
    }

    public PeopleData withEmail(String email) {
        this.email = email;
        return this;
    }

    public PeopleData withDeveloper(boolean developer) {
        isDeveloper = developer;
        return this;
    }

    public PeopleData withAge(int age) {
        this.age = age;
        return this;
    }

    public PeopleData withUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
        return this;
    }

    public PeopleData withId(String id) {
        this.id = id;
        return this;
    }

    public PeopleData(String nameNew, String emailNew, int ageNew, boolean isDeveloperNew, UserAddress userAddressNew, String idNew) {
        name = nameNew;
        email = emailNew;
        age = ageNew;
        isDeveloper = isDeveloperNew;
        userAddress = userAddressNew;
        id = idNew;
    }

    public PeopleData(String nameNew, String emailNew, int ageNew, boolean isDeveloperNew, UserAddress userAddressNew) {
        name = nameNew;
        email = emailNew;
        age = ageNew;
        isDeveloper = isDeveloperNew;
        userAddress = userAddressNew;
    }
}

