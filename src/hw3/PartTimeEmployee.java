package hw3;

public class PartTimeEmployee extends Employee implements Comparable<PartTimeEmployee>{

    private double hourlyRate;

    public PartTimeEmployee(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateAverageWage() {
        return 20.8 * 8 * hourlyRate;
    }

    public int compareTo(PartTimeEmployee employee) {
        if (this.hourlyRate == employee.hourlyRate) return 0;
        else if (this.hourlyRate < employee.hourlyRate) return -1;
        else return 1;
    }
}
