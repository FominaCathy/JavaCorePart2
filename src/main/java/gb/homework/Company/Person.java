package gb.homework.Company;

import java.time.LocalDate;

abstract class Person {
    protected String firstName;
    protected String lastName;
    private LocalDate birthday;

    public Person(String firstName, String lastName, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public int getAge() {
        if (LocalDate.now().getMonthValue() < birthday.getMonthValue()) {
            return LocalDate.now().getYear() - birthday.getYear() - 1;
        }
        return LocalDate.now().getYear() - birthday.getYear();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
