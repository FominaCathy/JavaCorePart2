package gb.homework.Company;

import java.time.LocalDate;
import java.util.List;

public class Chief extends Employee {
    public Chief(String firsName, String lastName, LocalDate birthday, String phone, double salary) {
        super(firsName, lastName, birthday, Staff.LEAD, phone, salary);
    }

    public Chief(String firsName, String lastName, LocalDate birthday) {
        super(firsName, lastName, birthday, Staff.LEAD);
    }

    public static void upgradeSalary(List<Employee> department, int sumUpgrade) {
        for (Employee item : department) {
            if (item instanceof Chief) {
                continue;
            }
            item.setSalary(item.getSalary() + sumUpgrade);
        }

    }

    @Override
    public String toString() {
        return "Chief: " + firstName + ' ' + lastName + ", age = " + this.getAge() + ", post: " + this.getPost() +
                ", phone: " + this.getPhone() + ", salary= " + this.getSalary() + ".";
    }

}
