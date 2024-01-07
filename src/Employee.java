import java.util.Objects;

public class Employee {
    private final Integer id;
    private final String employeeName; //ФИО сотрудника
    private int salary = 0; // зарплата сотрудника
    private int department = 0; // отдел (от 1 до 5)

    private static Integer idCounter = 1;

    //коснтруктор класса
    public Employee(String employeeName, int salary, int department) {
        this.id = idCounter++;
        this.employeeName = employeeName;
        this.salary = salary;
        this.department = department;
    }

    //Геттеры


    public String getEmployeeName() {
        return employeeName;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public Integer getId() {
        return id;
    }

    //Сеттеры
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(byte department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return salary == employee.salary && department == employee.department && Objects.equals(id, employee.id) && Objects.equals(employeeName, employee.employeeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeName, salary, department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }



}
