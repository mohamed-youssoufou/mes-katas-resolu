package ci.dojo;


/*
Toutes les années divisibles par 400 SONT des années bissextiles (ainsi par exemple, 2000 était bien une année bissextile),
Toutes les années divisibles par 100 mais pas par 400 ne sont PAS des années bissextiles (ainsi, par exemple, 1700, 1800 et 1900 n'étaient PAS des années bissextiles, et 2100 ne sera PAS non plus une année bissextile),
Toutes les années divisibles par 4 mais pas par 100 SONT des années bissextiles (ex : 2008, 2012, 2016),
Toutes les années non divisibles par 4 ne sont PAS des années bissextiles (par exemple 2017, 2018, 2019).
 */
public class LeapYears {
    public boolean isLeapYear(int year) {
        if(year % 4 == 0 && year % 100 != 0) return true;
        if(year % 400 == 0) return true;
        return false;
    }
}
