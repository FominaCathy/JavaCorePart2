package gb.homework.Company;

import java.util.Comparator;

public class ComparatorByFirstName implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.firstName.compareTo(o2.firstName);
    }
}
