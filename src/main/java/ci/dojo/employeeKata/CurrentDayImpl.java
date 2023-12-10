package ci.dojo.employeeKata;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CurrentDayImpl implements IToday{
    @Override
    public String whatsIsTheDay() {
        LocalDate date = LocalDate.now();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        Locale Local = Locale.FRENCH;
        return dayOfWeek.getDisplayName(TextStyle.FULL, Local);
    }
}