package gb.homework.Company;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o2.getBirthday().compareTo(o1.getBirthday());
    }
}
