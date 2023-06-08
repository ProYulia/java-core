package hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static List<Employee> employeeList = new ArrayList<>();
    private static Random random = new Random();

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            int rate = random.nextInt(150, 500);
            employeeList.add(new PartTimeEmployee(rate));
        }

        for (int i = 0; i < 5; i++) {
            int rate = random.nextInt(50_000, 300_000);
            employeeList.add(new RegularEmployee(rate));
        }
        Company myCompany = new Company(employeeList,"company1");
        myCompany.printEmployeeList();

    }
}
