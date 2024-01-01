public class Main {
    //Создание списка сотрудников - 10 чел.
    private static final Employee[] employees = {
            new Employee("Кузькин Никифор Евлампиевич", 100000, 1),
            new Employee("Гукк Виктор Сергеевич", 10000, 2),
            new Employee("Гажа Ирина Сергеевна", 70000, 3),
            new Employee("Виктюк Алёна Ивановна", 200000, 4),
            new Employee("Петренко Семён Анатольевич", 150000, 5),
            new Employee("Фомин Илья Евгеньевич", 83000, 1),
            new Employee("Музычко Ольга Ефремовна", 80125, 2),
            new Employee("Крень Игорь Сергеевич", 69874, 3),
            new Employee("Ильжев Кемран Ваникович", 157425, 4),
            new Employee("Князева Светлана Викторовна", 89999, 5)
    };

    public static void main(String[] args) {
        //п. a - Получить список всех сотрудников
        System.out.println("---   п. a: вывод списка всех сотрудников (всех полей) - toString:");
        printOfEmployees();
        System.out.println();

        // п. b - Посчитать сумму затрат на зарплаты в месяц
        System.out.println("---   п. b: сумма затрат на зарплаты в месяц (ФОТ):");
        System.out.println(calculateTotalSalary() + " р. \n");

        // п. c - Найти сотрудника с минимальной зарплатой
        System.out.println("--- п. c: сотрудник с минимальной зарплатой:");
        System.out.println(findEmployeeWithMinSalary() + "\n");

        //п. d - Найти сотрудника с максимальной зарплатой
        System.out.println("--- п. d: сотрудник с максимальной зарплатой:");
        System.out.println(findEmployeeWithMaxSalary() + "\n");

        //п. e - Подсчитать среднее значение зарплат
        System.out.println("---   п. e - среднее значение зарплат:");
        System.out.println(calculateAverageSalary() + " р. \n");

        //п. f - Получить Ф. И. О. всех сотрудников (вывести в консоль)
        System.out.println("---   п. f - Ф. И. О. всех сотрудников:");
        printEmployeeName();
    }

    //п. a - Получить список всех сотрудников
    public static void printOfEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    // п.b - Посчитать сумму затрат на зарплаты в месяц
    public static int calculateTotalSalary() {
        int fot = 0; //Фонд Оплаты Труда = сумма зарплат.
        for (Employee employee : employees) {
            fot += employee.getSalary();
        }
        return fot;
    }

    // п. c - Найти сотрудника с минимальной зарплатой
    public static String findEmployeeWithMinSalary() {
        Employee res = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() < res.getSalary()) {
                res = employee;
            }
        }
        return "Сотрудник " + res.getEmployeeName() + " получает самую маленькую зарплату - " + res.getSalary() + " р.";
    }

    // п. d - Найти сотрудника с максимальной зарплатой
    public static String findEmployeeWithMaxSalary() {
        Employee res = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > res.getSalary()) {
                res = employee;
            }
        }
        return "Сотрудник " + res.getEmployeeName() + " получает самую большую зарплату - " + res.getSalary() + " р.";
    }

    //п. e - Подсчитать среднее значение зарплат
    public static float calculateAverageSalary() {
        return (float) calculateTotalSalary() / employees.length;
    }

    ////п. f - Получить Ф. И. О. всех сотрудников (вывести в консоль)
    public static void printEmployeeName() {
        for (Employee employee : employees) {
            System.out.println(employee.getEmployeeName());
        }

    }

}