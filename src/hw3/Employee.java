package hw3;

public abstract class Employee {

    private long id;
    private static long idCounter;

    public Employee() {
        idCounter++;
        id = idCounter;
    }

    public abstract double calculateAverageWage();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                '}';
    }
}
