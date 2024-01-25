package gb.homework.Company;

import java.time.LocalDate;

public class Employee extends Person {
    private Staff post;
    private String phone;
    private double salary;

    public Employee(String firsName, String lastName, LocalDate birthday, Staff staff, String phone, double salary) {
        super(firsName, lastName, birthday);
        this.post = staff;
        this.phone = phone;
        this.salary = salary;

    }

    public Employee(String firsName, String lastName, LocalDate birthday, Staff staff) {
        super(firsName, lastName, birthday);
        this.post = staff;
        this.phone = "-";
        this.salary = 0.0;
    }

    @Override
    public String toString() {
        return "Employee: " + firstName + ' ' + lastName + ", age = " + this.getAge() + ", post: " + post +
                ", phone: " + phone + ", salary= " + salary + ".";
    }

    public Staff getPost() {
        return post;
    }

    public String getPhone() {
        return phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setPost(Staff post) {
        this.post = post;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


}
