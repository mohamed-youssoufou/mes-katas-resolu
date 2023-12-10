package ci.dojo;

import ci.dojo.employeeKata.CurrentDayImpl;
import ci.dojo.employeeKata.Employee;
import ci.dojo.employeeKata.IToday;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import ci.dojo.employeeKata.EmployeeReport;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeReportTest {

    private EmployeeReport employeeReport;
    private Employee employee;
    IToday iToday;
    Locale Local = Locale.FRENCH;

    @BeforeEach
    void setUp(){
        iToday = new CurrentDayImpl();
        employeeReport = new EmployeeReport(
                iToday,
                new Employee("Max", 17),
                new Employee("Sepp", 18),
                new Employee("Nina", 15),
                new Employee("Mike", 51)
        );
    }

    @Test
    void shouldToDayIsSunDay(){
        assertEquals(DayOfWeek.SUNDAY.getDisplayName(TextStyle.FULL, Local), employeeReport.today());
    }

    @Test
    void shouldEmployeeIsAutorise(){
        Assertions.assertEquals(false, employeeReport.getAllEmployee().get(0).isAutorise(iToday));
        Assertions.assertEquals(true, employeeReport.getAllEmployee().get(1).isAutorise(iToday));
        Assertions.assertEquals(false, employeeReport.getAllEmployee().get(2).isAutorise(iToday));
        Assertions.assertEquals(true, employeeReport.getAllEmployee().get(3).isAutorise(iToday));
    }

    @Test void shouldReturn2(){
        assertEquals(2L, employeeReport.getAllEmployee().stream().filter(e -> e.isAutorise(iToday)).count());
    }

    @Test void shouldReturnSteppAndMike(){
        assertEquals(
                    Arrays.asList(
                            employeeReport.getAllEmployee().get(1), 
                            employeeReport.getAllEmployee().get(3)
                    ),
                    EmployeeReport.getEmployeeOlderThan18year(employeeReport.getAllEmployee())
                );
    }

    @Test void shouldReturnMaxMikeNinaStepp(){
        assertEquals(
                Arrays.asList(
                        employeeReport.getAllEmployee().get(0),
                        employeeReport.getAllEmployee().get(3), employeeReport.getAllEmployee().get(2), employeeReport.getAllEmployee().get(1)),
                EmployeeReport.getAllOrderThanName(employeeReport.getAllEmployee()));
    }

    @Test void shouldReturnMakeNameToUpperCase(){
        List<Employee> employeeList = Arrays
                .asList(
                        employeeReport.getAllEmployee().get(0), 
                        employeeReport.getAllEmployee().get(3), 
                        employeeReport.getAllEmployee().get(2), 
                        employeeReport.getAllEmployee().get(1))
                .stream()
                .map(employee -> {
                    employee.setName(employee.getName().toUpperCase());
                    return employee;
                })
                .collect(Collectors.toList());
        assertEquals(
                employeeList,
                EmployeeReport.getNameToUpperCAse(employeeReport.getAllEmployee()));
    }

    @Test void shouldReturnSteppNinaMikeMax(){
        assertEquals(
                Arrays.asList(
                        employeeReport.getAllEmployee().get(1) ,
                        employeeReport.getAllEmployee().get(2),
                        employeeReport.getAllEmployee().get(3),
                        employeeReport.getAllEmployee().get(0)
                ),
                EmployeeReport.getAllOrderThanNameReverse(employeeReport.getAllEmployee()));
    }

}
