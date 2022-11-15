package it.unibo.nestedenum;

import java.util.Comparator;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    private enum Month {
        January("January", 31),
        February("February", 28),
        March("March", 31),
        April("April", 30),
        May("May", 31),
        June("June", 30),
        July("July", 31),
        August("August", 31),
        September("September", 30),
        October("October", 31),
        November("November", 30),
        Dicember("Dicember", 31);

        public String name;
        public int days;

        private Month(String name, int days) {
            this.name = name;
            this.days = days;
        }


        public static Month fromString(String search) {
            int temp;
            int nearestToZero = Integer.MIN_VALUE;
            Month result = null;
            for (Month m : Month.values()) {
                if ((temp = search.compareTo(m.name)) < 0 && search.length() < m.name.length() 
                    && temp > nearestToZero) {
                    nearestToZero = temp;
                    result = m;
                } else if (temp == nearestToZero) {
                    throw new IllegalArgumentException("Input string found 2 or more similar months");
                }
            }
            if (search.length() >= result.name.length() && 
                !search.equalsIgnoreCase(result.name)) {
                    throw new IllegalArgumentException("Input string is not valid");
                }
            return result;
        }
    }    

    @Override
    public Comparator<String> sortByDays() {
        return new Comparator<String>() {
            @Override
            public int compare(String arg0, String arg1) {
                return Integer.compare(Month.fromString(arg0).days, Month.fromString(arg1).days);
            }            
        };
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new Comparator<String>() {
            @Override
            public int compare(String arg0, String arg1) {
                return Month.fromString(arg0).name.compareTo(Month.fromString(arg1).name);
            }            
        };
    }
}
