package hw3;

import java.util.List;

public class Company {

    private List<Employee> employeeList;
    private String companyName;

    public Company(List<Employee> employeeList, String companyName) {
        this.employeeList = employeeList;
        this.companyName = companyName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void printEmployeeList() {
        for (Employee employee:employeeList) {
            System.out.println(employee.getId() + " " + Math.round(employee.calculateAverageWage()));
        }
    }
}
