package gb.homework.Company;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> company = new ArrayList<>();
        company.add(new Employee("Smit", "Uill", LocalDate.of(1960, 01, 01),
                Staff.DEV, "02-02-02", 2000));
        company.add(new Employee("Dark", "Yan", LocalDate.of(1999, 10, 01),
                Staff.DEV, "02-02-03", 1500));
        company.add(new Employee("White", "Lola", LocalDate.of(2003, 9, 12),
                Staff.DEV, "02-02-04", 1500));
        company.add(new Employee("By", "Mila", LocalDate.of(2004, 8, 11),
                Staff.TEST, "02-02-04", 1500));
        company.add(new Chief("Toto", "Ctas", LocalDate.of(2004, 8, 12),
                "02-02-05", 2500));

        System.out.println("\nlist employee:");
        printList(company);

        System.out.println("\naverage age in company: " + averageAge(company));
        System.out.println("\naverage salary in company: " + averageSalary(company));


        Chief.upgradeSalary(company, 1000);
        System.out.println("\nlist employee after upgrade salary:");
        printList(company);

        System.out.println("\naverage salary in company: " + averageSalary(company));

        Comparator byFirstName = new ComparatorByFirstName();
        Collections.sort(company, byFirstName);

        System.out.println("\nlist employee after sorted by first name:");
        printList(company);

        Comparator byAge = new ComparatorByAge();
        Collections.sort(company, byAge);

        System.out.println("\nlist employee after sorted by age:");
        printList(company);


    }

    private static void printList(List<Employee> department) {
        department.stream().forEach(System.out::println);
    }

    private static float averageAge(List<Employee> department) {
        double sum = 0;
        for (Employee item : department) {
            sum += item.getAge();
        }
        return (float) sum / department.size();
    }

    private static float averageSalary(List<Employee> department) {
        double sum = 0;
        for (Employee item : department) {
            sum += item.getSalary();
        }
        return (float) sum / department.size();
    }
}
