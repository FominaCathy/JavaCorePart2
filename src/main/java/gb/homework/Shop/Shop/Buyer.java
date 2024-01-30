package gb.homework.Shop.Shop;

public class Buyer {
    private String login;
    private String firstName;
    private String lastName;

    private Gender gender;

    public Buyer(String login, String firstName, String lastName, Gender gender) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }


    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public Gender getGender() {
        return gender;
    }
}
