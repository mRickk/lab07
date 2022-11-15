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

        private String monthName;
        private int days;

        private Month(String name, int days) {
            this.monthName = name;
            this.days = days;
        }


        public static Month fromString(String search) {
            int temp;
            int min = Integer.MAX_VALUE;
            Month result = Month.January;
            for (Month month : Month.values()) {
                if ((temp = month.monthName.compareTo(search)) < min) {
                    min = temp;
                    result = month;
                } else if (temp == min) {
                    throw new IllegalArgumentException("Input string found 2 or more similar months");
                } else {
                    throw new IllegalArgumentException("Input string is not valid");
                }
            }
            if (search.length() >= result.monthName.length() &&
                !search.equalsIgnoreCase(result.monthName)) {
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
                return Month.fromString(arg0).monthName.compareTo(Month.fromString(arg1).monthName);
            }            
        };
    }
}
