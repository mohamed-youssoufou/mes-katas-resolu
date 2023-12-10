package ci.dojo.employeeKata;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;

public class Employee implements Comparable<Employee>{
    private String name;
    private int age;


    final private Locale locale = Locale.FRENCH;

    @Override
    public int compareTo(Employee otherEmployee) {
        return this.name.compareTo(otherEmployee.getName());
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }


    public Boolean isAutorise(IToday iToday) {
        if(!iToday.whatsIsTheDay().equals(DayOfWeek.SUNDAY.getDisplayName(TextStyle.FULL, locale))) return false;
        return this.age >= 18 ? true : false;
    }
}
