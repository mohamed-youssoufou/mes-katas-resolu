package ci.dojo.employeeKata;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeReport {
    private List<Employee> employees;
    public  static IToday iToday;

    public EmployeeReport(IToday iToday, Employee... employees) {
        this.employees = Arrays.asList(employees);
        this.iToday = iToday;
    }

    public List<Employee> getAllEmployee(){
       return employees;
    }

    public static List<Employee> getNameToUpperCAse(List<Employee> employees) {
        return  getAllOrderThanName(employees)
                .stream()
                .map(employee -> {
                    employee.setName(employee.getName().toUpperCase());
                    return employee;
                })
                .collect(Collectors.toList());
    }

    public static List<Employee> getAllOrderThanNameReverse(List<Employee> employees) {
        Collections.sort(employees, Comparator.comparing(Employee::getName).reversed());
        return employees;
    }

    public static List<Employee> getEmployeeOlderThan18year(List<Employee> employees) {
        return employees.stream().filter(e -> e.isAutorise(iToday)).collect(Collectors.toList());
    }

    public static List<Employee> getAllOrderThanName(List<Employee> employees) {
        return employees.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
    }

    public String today() {
        return iToday.whatsIsTheDay();
    }
}
