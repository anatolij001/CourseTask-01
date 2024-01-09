import java.util.PrimitiveIterator;

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

        // Базовая сложность
        System.out.println("---   БАЗОВАЯ СЛОЖНОСТЬ   ---");
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
        System.out.println("---   п. f - Ф. И. О. всех сотрудников:\n");
        printEmployeeName();

        // Повышенная сложность
        System.out.println("\n---   ПОВЫШЕННАЯ СЛОЖНОСТЬ   ---\n");
        // П.1 Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).
        System.out.println("П.1 Проиндексировать зарплату у всех сотрудников на величину аргумента в %\n");
        System.out.println("До индексации зарплат: ");
        printOfEmployees();
        indexSalary(10);
        System.out.println("После индексации зарплат: ");
        printOfEmployees();

        //П.2 a. - Найти сотрудника с минимальной зарплатой в департаменте:
        System.out.println("\nП.2 a. - Найти сотрудника с минимальной зарплатой в департаменте:");
        System.out.println(findEmployeeWithMinSalaryInDep(1));

        //П.2 b. - Найти сотрудника с максимальной зарплатой в департаменте:
        System.out.println("\nП.2 b. - Найти сотрудника с максимальной зарплатой в департаменте:");
        System.out.println(findEmployeeWithMaxSalaryInDep(1));

        //П.2 c. - Найти сумму затрат на зарплату по отделу:
        System.out.println("\nП.2 c. - Найти сумму затрат на зарплату по отделу 1:");
        System.out.println(calculateTotalSalaryInDep(1));


        //П.2 d. - Найти cреднюю зарплату по отделу:
        System.out.println("\nП.2 d. - Найти cреднюю зарплату по отделу 1:");
        System.out.println(calculateAverageDepSalary(1));

        //П.2 e. - Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра:
        System.out.println("\nП.2 e. - Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра:");
        System.out.println("Зарплата отдела " + 1 + " до индексации на 10%:");
        printDepEmployee(1);
        indexSalaryInDep(10, 1);
        System.out.println("Зарплата отдела " + 1 + " после индексации на 10%:");
        printDepEmployee(1);

        //П.2.f. - Напечатать всех сотрудников отдела (все данные, кроме отдела)

        System.out.println("\nП.2.f. : Напечатать всех сотрудников отдела 1 (все данные, кроме отдела):");
       //
        printDepEmployee(1);

        //П.3.a.:
        System.out.println("\nСотрудникик, зарплата котороых < 100 000 р.:");
        printAllEmployeesWithSalaryLess(100000);
        //П.3.b.:
        System.out.println("\nСотрудникик, зарплата котороых >= 100 000 р.:");
        printAllEmployeesWithSalaryMore(100000);

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

    // Продвинутая часть. Создать дополнительные статические методы для решения следующих задач:
    // 1. Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %):
    private static void indexSalary(int percent) {
        for (Employee employee : employees) {
            int currentSalary = employee.getSalary();
            int newSalary = (int) (currentSalary + currentSalary * percent / 100f);
            employee.setSalary(newSalary);
        }
    }

    // 2. Получить в качестве параметра номер отдела (1–5) и найти:
    // 2.a. Сотрудника с минимальной зарплатой в отделе:
    private static String findEmployeeWithMinSalaryInDep(int department) {
        int minSalary = Integer.MAX_VALUE;
        Employee res = null;


        for (Employee employee : employees) {
            if (employee.getDepartment() != department) {
                continue;
            }
            if (employee.getSalary() < minSalary) {
                res = employee;
                minSalary = employee.getSalary();
            }
        }
        return "Сотрудник с минимальной зарплатой в отделе " + department + " - " + res.getEmployeeName() + ".";
    }

    //2.b. Сотрудника с максимальной зарплатой в отделе:
    private static String findEmployeeWithMaxSalaryInDep(int department) {
        int maxSalary = Integer.MIN_VALUE;
        Employee res = null;


        for (Employee employee : employees) {
            if (employee.getDepartment() != department) {
                continue;
            }
            if (employee.getSalary() > maxSalary) {
                res = employee;
                maxSalary = employee.getSalary();
            }
        }
        return "Сотрудник с максимальной зарплатой в отделе " + department + " - " + res.getEmployeeName() + ".";
    }

    //2.c. Сумму затрат на зарплату по отделу:
    private static int calculateTotalSalaryInDep(int department) {
        int fotDep = 0; //Фонд Оплаты Труда = сумма зарплат по отделу.
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                fotDep += employee.getSalary();
            }
        }
        return fotDep;
    }

    //2.d Среднюю зарплату по отделу (учесть, что количество людей в отделе отличается от employees.length).
    private static float calculateAverageDepSalary(int department) {
        int depEmployeeCount = 0;
//        int depTotalSalary = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                depEmployeeCount++;
//                depTotalSalary = depTotalSalary + employee.getSalary();
            }
        }
        return (float) calculateTotalSalaryInDep(department) / depEmployeeCount;
    }

    //2.e. Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
    private static void indexSalaryInDep(int percent, int department) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                int currentSalary = employee.getSalary();
                int newSalary = (int) (currentSalary + currentSalary * percent / 100f);
                employee.setSalary(newSalary);
            }

        }
    }

    //2.f. Напечатать всех сотрудников отдела (все данные, кроме отдела)
    private static void printDepEmployee(int department) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == department){
                System.out.println("ФИО = " + employee.getEmployeeName() + ". Зарплата = " + employee.getSalary());}
        }

    }

    // 3. Получить в качестве параметра число и найти:
    // 3.a. Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
    private static void printAllEmployeesWithSalaryLess(int loockSalary){
        for(Employee employee : employees){
            if (employee.getSalary() < loockSalary){
                System.out.println("ID = " + employee.getId() + ". ФИО = " + employee.getEmployeeName() + ". Зарплата = " + employee.getSalary());
            }
        }
    }

    // 3.b. Всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль).
    private static void printAllEmployeesWithSalaryMore(int loockSalary){
        for(Employee employee : employees){
            if (employee.getSalary() >= loockSalary){
                System.out.println("ID = " + employee.getId() + ". ФИО = " + employee.getEmployeeName() + ". Зарплата = " + employee.getSalary());
            }
        }
    }


}