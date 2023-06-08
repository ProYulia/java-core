package hw3;

public class RegularEmployee extends Employee implements Comparable<RegularEmployee> {
    private double salary;

    public RegularEmployee(double salary) {
        this.salary = salary;
    }

    @Override
    public double calculateAverageWage() {
        return salary;
    }


    public int compareTo(RegularEmployee employee) {
        if (this.salary == employee.salary) return 0;
        else if (this.salary < employee.salary) return -1;
        else return 1;
    }

}
