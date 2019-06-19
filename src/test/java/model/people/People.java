package model.people;

public class People {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDeveloper() {
        return isDeveloper;
    }

    public void setDeveloper(boolean developer) {
        isDeveloper = developer;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String email;
    boolean isDeveloper;
    int age;
    UserAddress userAddress;
    String id;

    public People(String nameNew, String emailNew, int ageNew, boolean isDeveloperNew, UserAddress userAddressNew, String idNew) {
        name = nameNew;
        email = emailNew;
        age = ageNew;
        isDeveloper = isDeveloperNew;
        userAddress = userAddressNew;
        id = idNew;
    }

    public People(String nameNew, String emailNew, int ageNew, boolean isDeveloperNew, UserAddress userAddressNew) {
        name = nameNew;
        email = emailNew;
        age = ageNew;
        isDeveloper = isDeveloperNew;
        userAddress = userAddressNew;
    }
}

