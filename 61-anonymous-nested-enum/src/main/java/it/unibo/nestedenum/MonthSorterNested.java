package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

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

        public Month fromString(String search) {
            
        }
    }

    

    @Override
    public Comparator<String> sortByDays() {
        return null;
    }

    @Override
    public Comparator<String> sortByOrder() {
        return null;
    }
}
